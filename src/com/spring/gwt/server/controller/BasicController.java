package com.spring.gwt.server.controller;

import java.util.logging.Logger;

public class BasicController {
	
	public static Logger LOG() {
		return LOG(null);
	}
	public static Logger LOG(String name) {
		if(name == null || name.isEmpty()) {
			name = BasicController.class.getName();
		}
		return Logger.getLogger(name);
	}
}
