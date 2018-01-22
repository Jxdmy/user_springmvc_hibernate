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

import online.qsx.model.Job;
import online.qsx.service.impl.JobServiceImpl;

//http://localhost:8080/user_springmvc_hibernate/job/list
@Controller
@RequestMapping("job")
public class JobController {
	@Autowired
	private JobServiceImpl jobServiceImpl;
	
	private List<Job> job_list;
	
	private Job jobDemo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date newDate;

	public List<Job> getJob_list() {
		return job_list;
	}

	public void setJob_list(List<Job> job_list) {
		this.job_list = job_list;
	}
	public Job getJobDemo() {
		return jobDemo;
	}
	public void setJobDemo(Job jobDemo) {
		this.jobDemo = jobDemo;
	}
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView job(ModelAndView modelAndView) {
		job_list = jobServiceImpl.findAll(null);
		modelAndView.addObject("job_list",job_list);
		modelAndView.setViewName("job");
		return modelAndView;
	}
	@GetMapping("addJob")
	public ModelAndView to_addJob(ModelAndView modelAndView) {
		newDate = new Date();
		modelAndView.addObject("newDate", newDate);
		modelAndView.setViewName("add_job");
		return modelAndView;
	}
	@RequestMapping(value="do_addJob",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView do_addJob(ModelAndView modelAndView,Job job) {
		jobServiceImpl.save(job);
		modelAndView.setViewName("redirect:/user/index.do");
		return modelAndView;
	}
	
	@RequestMapping(value="remove",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView remove(ModelAndView modelAndView,Job job) {
		jobServiceImpl.remove(job);
		modelAndView.setViewName("redirect:/user/index.do");
		return modelAndView;
	}
	
	@GetMapping("to_edit")
	public ModelAndView to_edit(ModelAndView modelAndView,Job job) {
		jobDemo = jobServiceImpl.findById(job);
		modelAndView.addObject("jobDemo",jobDemo);
		modelAndView.setViewName("to_edit_job");		
		return modelAndView;
	}
	
	@PostMapping("do_edit")
	public ModelAndView do_edit(ModelAndView modelAndView,Job job) {
		jobServiceImpl.edit(job);
		modelAndView.setViewName("redirect:/user/index.do");
		return modelAndView;
	}
}
