package com.spring.gwt.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController extends BasicController {

//	PAGE
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "home";
	}
	
	@RequestMapping(value = "/cms", method = RequestMethod.GET)
	public String cms(Model model, HttpServletRequest request, HttpServletResponse response) {
		LOG().warning("CMS page");
		return "cms";
	}
}
