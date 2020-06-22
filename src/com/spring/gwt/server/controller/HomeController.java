package com.spring.gwt.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController extends BasicController {

//	PAGE
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model, HttpServletRequest request, HttpServletResponse response) {
		getCurrentUserInfoBySession(model, response, request);
		return "home";
	}

	//	API
	@RequestMapping(value = "/get-string", method = RequestMethod.GET)
	public @ResponseBody String getString(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "OK";
	}
}
