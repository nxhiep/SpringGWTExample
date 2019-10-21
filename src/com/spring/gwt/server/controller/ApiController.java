package com.spring.gwt.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.gwt.server.dao.DAO;
import com.spring.gwt.shared.UserFaceBook;

@Controller
@RequestMapping(value = "/api")
public class ApiController {

//	API
	@RequestMapping(value = "/import-user", method = RequestMethod.GET)
	public @ResponseBody UserFaceBook importUserGET(HttpServletRequest request) {
		return getUser(request);
	}
	
	@RequestMapping(value = "/import-user", method = RequestMethod.POST)
	public @ResponseBody UserFaceBook importUserPOST(HttpServletRequest request) {
		return getUser(request);
	}
	
	public UserFaceBook getUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if(id == null || id.isEmpty() || password == null || password.isEmpty()) {
			return null;
		}
		return new DAO().importUserFacebook(id, password);
	}
}
