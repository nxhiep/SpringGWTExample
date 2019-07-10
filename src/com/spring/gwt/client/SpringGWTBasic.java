package com.spring.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.spring.gwt.client.activities.AppPlaceHistoryMapper;
import com.spring.gwt.client.activities.AsyncActivityManager;
import com.spring.gwt.client.activities.AsyncActivityMapper;
import com.spring.gwt.client.activities.ClientFactory;
import com.spring.gwt.client.activities.ClientFactoryImpl;
import com.spring.gwt.client.activities.SplitAppActivityMapper;
import com.spring.gwt.client.activities.home.HomePlace;

public class SpringGWTBasic implements EntryPoint {
	
	public void onModuleLoad() {
		ClientFactory clientFactory = new ClientFactoryImpl();
        
		SimplePanel display = new SimplePanel();
		AsyncActivityMapper activityMapper = new SplitAppActivityMapper(clientFactory);
		AsyncActivityManager activityManager = new AsyncActivityManager(activityMapper, clientFactory.getEventBus());
		activityManager.setDisplay(display);
		
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new HomePlace());
		historyHandler.handleCurrentHistory();
		RootPanel.get("root-panel").add(display);
	}
}
