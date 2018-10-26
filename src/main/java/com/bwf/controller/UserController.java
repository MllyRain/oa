package com.bwf.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.StringUtils;

@Controller
@RequestMapping("user")
public class UserController {
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	@GetMapping("login")
	public String login(){
		return "user/login";
	}
	
	@PostMapping("doLogin")
	public void doLogin(User user){				
		logger.info("{}, {}" , user.getUsername() , user.getPassword());		
		//把密码进行加密
		user.setPassword(StringUtils.md5(user.getPassword()));
		logger.info("password : {}",user.getPassword());
		//执行登录 功能
		User loginUser=userService.login(user);
		
		if(loginUser==null){
			//登录失败
			logger.info("登录失败，用户名或密码错误");
			//带着错误信息，跳转到登录界面
			
			//return "redirect:/user/login";
		}else{
			//登录成功
			logger.info("登录成功");

			//写入session
			
			//跳转到首页
			//return "redirect:/index/index";			
		} 

	}
	

}
