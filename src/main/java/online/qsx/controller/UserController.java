package online.qsx.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import online.qsx.model.Hobby;
import online.qsx.model.Job;
import online.qsx.model.Page;
import online.qsx.model.User;
import online.qsx.service.impl.HobbyServiceImpl;
import online.qsx.service.impl.JobServiceImpl;
import online.qsx.service.impl.UserServiceImpl;

//http://localhost:8080/user_springmvc_hibernate/user/index
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private JobServiceImpl jobServiceImpl;

	@Autowired
	private HobbyServiceImpl hobbyServiceImpl;	
	
	private List<Job> job_list;
	private List<Hobby> hobby_list;	
	private List<User> list;
	private User oneUser;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date newDate;

	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public User getOneUser() {
		return oneUser;
	}

	public void setOneUser(User oneUser) {
		this.oneUser = oneUser;
	}

	@PostMapping("do_upload")
	@ResponseBody
	public String do_upload(MultipartFile file, HttpServletRequest request) throws Exception {
		// 文件夹路径
		String url = request.getSession().getServletContext().getRealPath("/upload");
		if (!new File(url).exists()) {
			new File(url).mkdir();
		}
		System.out.println(url);
		// 文件名
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + file.getOriginalFilename()
				.substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
		System.out.println(fileName);
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(url + File.separator + fileName));

		return "{'url':'" + fileName + "'}";
	}	
	@RequestMapping(value = "index", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView index(ModelAndView modelAndView) {
		list = userServiceImpl.findAll(null);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping("userForm")
	public ModelAndView userForm(ModelAndView modelAndView) {
		hobby_list = hobbyServiceImpl.findAll(null);
		modelAndView.addObject("hobby_list",hobby_list);
		job_list = jobServiceImpl.findAll(null);
		modelAndView.addObject("job_list", job_list);
		newDate = new Date();
		modelAndView.addObject("newDate", newDate);
		modelAndView.setViewName("userForm");
		return modelAndView;
	}

	// http://localhost:8080/user_springmvc_hibernate/user/save
	@RequestMapping(value = "save", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView save(ModelAndView modelAndView, User user) {
		userServiceImpl.save(user);
		modelAndView.setViewName("forward:index.do");
		return modelAndView;
	}

	// http://localhost:8080/user_springmvc_hibernate/user/remove
	@RequestMapping(value = "remove", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView remove(ModelAndView modelAndView, User user) {
		userServiceImpl.remove(user);
		modelAndView.setViewName("forward:index.do");
		return modelAndView;
	}

	@RequestMapping(value = "to_edit", method = { RequestMethod.GET })
	public ModelAndView to_edit(ModelAndView modelAndView, User user) {
		job_list = jobServiceImpl.findAll(null);
		modelAndView.addObject("job_list", job_list);
		hobby_list = hobbyServiceImpl.findAll(null);
		modelAndView.addObject("hobby_list",hobby_list);
		oneUser = userServiceImpl.findById(user);
		modelAndView.addObject("user", oneUser);
		modelAndView.setViewName("edit");
		return modelAndView;
	}

	@RequestMapping(value = "do_edit", method = { RequestMethod.POST })
	public ModelAndView do_edit(ModelAndView modelAndView, User user) {
		userServiceImpl.edit(user);
		modelAndView.setViewName("forward:index.do");
		return modelAndView;
	}
}
