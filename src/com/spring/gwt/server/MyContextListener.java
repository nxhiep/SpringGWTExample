package com.spring.gwt.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.spring.gwt.shared.model.ActionInfo;
import com.spring.gwt.shared.model.ActivityInfo;
import com.spring.gwt.shared.model.ClusterStructure;
import com.spring.gwt.shared.model.Consumable;
import com.spring.gwt.shared.model.ConsumableInput;
import com.spring.gwt.shared.model.ConsumableOutput;
import com.spring.gwt.shared.model.Product;
import com.spring.gwt.shared.model.ProductMaterial;
import com.spring.gwt.shared.model.RoadTextTure;
import com.spring.gwt.shared.model.UserInfo;

public class MyContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(ActionInfo.class);
		ObjectifyService.register(ActivityInfo.class);
		ObjectifyService.register(ClusterStructure.class);
		ObjectifyService.register(Consumable.class);
		ObjectifyService.register(ConsumableInput.class);
		ObjectifyService.register(ConsumableOutput.class);
		ObjectifyService.register(Product.class);
		ObjectifyService.register(ProductMaterial.class);
		ObjectifyService.register(ProductMaterial.class);
		ObjectifyService.register(RoadTextTure.class);
		ObjectifyService.register(UserInfo.class);
	}
}
