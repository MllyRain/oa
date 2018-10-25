package com.bwf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.User;

@Controller
@RequestMapping("user")
public class UserController {
	
	//Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("login")
	public String login(){
		return "user/login";
	}
	
	@PostMapping("doLogin")
	public String doLogin(User user){
		System.out.println(user.getUsername()+""+user.getPassword());
		
		return "user/doLogin";
	}
	

}
