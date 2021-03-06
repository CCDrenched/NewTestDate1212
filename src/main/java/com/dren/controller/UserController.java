package com.dren.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dren.pojo.BackendUser;
import com.dren.pojo.DevUser;
import com.dren.service.BackendUserService;
import com.dren.service.DevUserService;

@Controller
public class UserController {
	@Autowired
	private DevUserService devUserService;
	@Autowired
	private BackendUserService backUserService;
	@RequestMapping(value="/devLogin",method=RequestMethod.GET)
	public String devLogin() {
		return "devLogin";
	}
	@RequestMapping(value="/devLogin",method=RequestMethod.POST)
	public String devLogin(DevUser devUser,HttpServletRequest request) {
		DevUser loginUser=devUserService.findDevUserByDevName(devUser.getDevName());
		if(loginUser == null) {
			return "devLogin";
		}
		if(loginUser.getDevPassword().equals(devUser.getDevPassword())) {
			request.getSession().setAttribute("loginUser", loginUser);
			return "redirect:dev/devMain";
		}else {
			return "devLogin";
		}
	}
	
	@RequestMapping(value="/dev/devMain",method=RequestMethod.GET)
	public String devMain() {
		return "dev/devMain";
	}
	@RequestMapping(value="/backendLogin",method=RequestMethod.GET)
	public String backendLogin() {
		return "backendLogin";
	}
	@RequestMapping(value="/backendLogin",method=RequestMethod.POST)
	public String backendLogin(BackendUser user,HttpServletRequest request) {
		BackendUser loginUser=backUserService.findUserByName(user.getBackendName());
		if(loginUser == null) {
			return "backendLogin";
		}
		if(loginUser.getBackendPassword().equals(user.getBackendPassword())) {
			request.getSession().setAttribute("loginUser", loginUser);
			return "redirect:backend/backendMain";
		}else {
			return "backendLogin";
		}
	}
	@RequestMapping(value="/backend/backendMain",method=RequestMethod.GET)
	public String backendMain() {
		return "backend/backendMain";
	}
	
	@RequestMapping(value="/{state}/logout",method=RequestMethod.GET)
	public String logout(@PathVariable("state")String state) {
		switch (state) {
		case "backend":
			return "backendLogin";
		case "dev":
			return "devLogin";
		default:
			return "index";
		}
	}
	public void setDevUserService(DevUserService devUserService) {
		this.devUserService = devUserService;
	}
	public void setBackUserService(BackendUserService backUserService) {
		this.backUserService = backUserService;
	}
	
	
}
