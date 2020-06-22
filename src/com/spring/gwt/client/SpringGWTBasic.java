package com.spring.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.spring.gwt.client.activities.AppActivityMapper;
import com.spring.gwt.client.activities.AppPlaceHistoryMapper;
import com.spring.gwt.client.activities.AsyncActivityManager;
import com.spring.gwt.client.activities.AsyncActivityMapper;
import com.spring.gwt.client.activities.ClientFactory;
import com.spring.gwt.client.activities.ClientFactoryImpl;
import com.spring.gwt.client.activities.home.HomePlace;
import com.spring.gwt.shared.model.UserInfo;

public class SpringGWTBasic implements EntryPoint {
	
	public void onModuleLoad() {
		ClientData.prepareData();
		ClientData.loginFromSession(new AsyncCallback<UserInfo>() {
			
			@Override
			public void onSuccess(UserInfo result) {
				onLoadedUserData();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				onLoadedUserData();
			}
		});
	}

	protected void onLoadedUserData() {
		ClientFactory clientFactory = new ClientFactoryImpl();
		SimplePanel display = new SimplePanel();
		display.setSize("100%", "100%");
		AsyncActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		AsyncActivityManager activityManager = new AsyncActivityManager(activityMapper, clientFactory.getEventBus());
		activityManager.setDisplay(display);
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new HomePlace());
		historyHandler.handleCurrentHistory();
		RootPanel.get("content").add(display);
	}
}
