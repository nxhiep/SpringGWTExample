package com.hust.textile.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.hust.textile.shared.model.ActionInfo;
import com.hust.textile.shared.model.ActivityInfo;
import com.hust.textile.shared.model.ClusterStructure;
import com.hust.textile.shared.model.Consumable;
import com.hust.textile.shared.model.ConsumableInput;
import com.hust.textile.shared.model.ConsumableOutput;
import com.hust.textile.shared.model.ProductInfo;
import com.hust.textile.shared.model.ProductMaterial;
import com.hust.textile.shared.model.RoadTextTure;
import com.hust.textile.shared.model.UserInfo;

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
		ObjectifyService.register(ProductInfo.class);
		ObjectifyService.register(ProductMaterial.class);
		ObjectifyService.register(ProductMaterial.class);
		ObjectifyService.register(RoadTextTure.class);
		ObjectifyService.register(UserInfo.class);
	}
}
