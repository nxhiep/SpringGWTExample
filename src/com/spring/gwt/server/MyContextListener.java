package com.spring.gwt.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.spring.gwt.shared.TestModel;
import com.spring.gwt.shared.UserFaceBook;
import com.spring.gwt.shared.UserInfo;

public class MyContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(TestModel.class);
		ObjectifyService.register(UserInfo.class);
		ObjectifyService.register(UserFaceBook.class);
	}
}
