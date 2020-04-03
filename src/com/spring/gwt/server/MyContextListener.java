package com.spring.gwt.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.spring.gwt.shared.model.Discussion;
import com.spring.gwt.shared.model.MealInfo;
import com.spring.gwt.shared.model.MealRate;
import com.spring.gwt.shared.model.TestModel;
import com.spring.gwt.shared.model.UserInfo;
import com.spring.gwt.shared.model.UserLike;

public class MyContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(TestModel.class);
		ObjectifyService.register(MealInfo.class);
		ObjectifyService.register(MealRate.class);
		ObjectifyService.register(UserLike.class);
		ObjectifyService.register(Discussion.class);
		ObjectifyService.register(UserInfo.class);
	}
}
