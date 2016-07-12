package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entities.User;
import com.service.UserService;
	





@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/loginUI")
	public String loginUI(){
		return "login";
		
	}
	@RequestMapping(value="/login")
	public String login(String loginName,String password,HttpSession session,Map<String,Object> map){
		User loginUser = userService.loginCheck(loginName);
			if(loginUser!=null&&loginUser.getPassWord().equals(password)){
				session.setAttribute("loginUser", loginUser);
					return "index";
		}
		map.put("loginError", "用户名或密码错误");
		return "login";
	}
	@RequestMapping("/test")
	public String test(){
		return "login";
	}

}
