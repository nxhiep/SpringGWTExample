package com.hust.textile.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hust.textile.shared.model.UserInfo;

@Controller
public class HomeController extends BasicController {

//	PAGE
	@RequestMapping(value = "/")
	public String homePage(Model model, HttpServletRequest request, HttpServletResponse response) {
		UserInfo currerntUser = getCurrentUserInfoBySession(model, response, request);
		if(currerntUser == null) {
			return "login";
		}
		return "home";
	}
}
