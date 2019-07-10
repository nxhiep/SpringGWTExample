package com.spring.gwt.client.activities;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.spring.gwt.client.activities.category.CategoryView;
import com.spring.gwt.client.activities.category.CategoryViewImpl;
import com.spring.gwt.client.activities.home.HomeView;
import com.spring.gwt.client.activities.home.HomeViewImpl;

public class ClientFactoryImpl implements ClientFactory {
	private SimpleEventBus eventBus;
	private PlaceController placeController;
	private HomeView homeView = new HomeViewImpl();
	private CategoryView categoryView = new CategoryViewImpl();
	
	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
		placeController = new PlaceController(eventBus);
	}
	
	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public HomeView getHomeView() {
		return homeView;
	}

	@Override
	public CategoryView getCategoryView() {
		return categoryView;
	}
}
