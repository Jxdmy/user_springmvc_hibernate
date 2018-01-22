package online.qsx.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import online.qsx.model.Hobby;
import online.qsx.service.impl.HobbyServiceImpl;

//http://localhost:8080/user_springmvc_hibernate/hobby/list
@Controller
@RequestMapping("hobby")
public class HobbyController {
	@Autowired
	private HobbyServiceImpl hobbyServiceImpl;	
	private List<Hobby> hobby_list;	
	private Hobby hobbyDemo;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date newDate;
	
	public List<Hobby> getHobby_list() {
		return hobby_list;
	}

	public void setHobby_list(List<Hobby> hobby_list) {
		this.hobby_list = hobby_list;
	}

	public Hobby getHobbyDemo() {
		return hobbyDemo;
	}

	public void setHobbyDemo(Hobby hobbyDemo) {
		this.hobbyDemo = hobbyDemo;
	}

	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}

	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView hobby(ModelAndView modelAndView) {
		hobby_list = hobbyServiceImpl.findAll(null);
		modelAndView.addObject("hobby_list",hobby_list);
		modelAndView.setViewName("hobby");
		return modelAndView;
	}
	@GetMapping("addHobby")
	public ModelAndView to_addHobby(ModelAndView modelAndView) {
		newDate = new Date();
		modelAndView.addObject("newDate", newDate);
		modelAndView.setViewName("add_hobby");
		return modelAndView;
	}
	//http://localhost:8080/user_springmvc_hibernate/hobby/do_addHobby
	@RequestMapping(value="do_addHobby",method={RequestMethod.POST})
	public ModelAndView do_addHobby(ModelAndView modelAndView,Hobby hobby) {
		hobbyServiceImpl.save(hobby);
		System.out.println("--------------addhobby");
		modelAndView.setViewName("redirect:/user/index.do");
		return modelAndView;
	}
	
	@RequestMapping(value="remove",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView remove(ModelAndView modelAndView,Hobby hobby) {
		hobbyServiceImpl.remove(hobby);
		modelAndView.setViewName("redirect:/user/index.do");
		return modelAndView;
	}
	
	@GetMapping("to_edit")
	public ModelAndView to_edit(ModelAndView modelAndView,Hobby hobby) {
		hobbyDemo = hobbyServiceImpl.findById(hobby);
		modelAndView.addObject("hobbyDemo",hobbyDemo);
		modelAndView.setViewName("to_edit_hobby");		
		return modelAndView;
	}
	
	@PostMapping("do_edit")
	public ModelAndView do_edit(ModelAndView modelAndView,Hobby hobby) {
		hobbyServiceImpl.edit(hobby);
		modelAndView.setViewName("redirect:/user/index.do");
		return modelAndView;
	}
}

