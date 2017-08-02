package com.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.model.User;
import com.ssm.service.LoginUserService;

@Controller
@RequestMapping("/user")
public class LoginUserController {

	@Resource
	private LoginUserService loginUserService;
	
	@RequestMapping("/login")
	public String exit(User user,HttpServletRequest request)
	{
		System.out.println(user);
		User resultUser = loginUserService.exit(user);
		if(resultUser==null){
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误");
			return "index";
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", resultUser);
			return "redirect:/success.jsp";
		}
	}
}
