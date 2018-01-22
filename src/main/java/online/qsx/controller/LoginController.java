package online.qsx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import online.qsx.model.Admin;
import online.qsx.service.impl.AdminServiceImpl;

//http://localhost:8080/user_springmvc_hibernate/admin
@Controller
@RequestMapping("/admin")
public class LoginController {
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@RequestMapping(value = "", method =RequestMethod.GET)
	public String to_login() {
		System.out.println("------------tologin");
		return "/login";
	}
	@RequestMapping(value = "do_login", method =RequestMethod.POST)
	public String do_login(Admin admin) {
		boolean is = adminServiceImpl.findByPwdAndName(admin);
		if(is){
			return "redirect:/user/index";
		}
		return "/login";
	}
}
