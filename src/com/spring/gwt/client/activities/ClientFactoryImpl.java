package com.spring.gwt.client.activities;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.spring.gwt.client.activities.category.CategoryView;
import com.spring.gwt.client.activities.category.CategoryViewImpl;
import com.spring.gwt.client.activities.consumable.ConsumableView;
import com.spring.gwt.client.activities.consumable.ConsumableViewImpl;
import com.spring.gwt.client.activities.consumable.type.ConsumableTypeView;
import com.spring.gwt.client.activities.consumable.type.ConsumableTypeViewImpl;
import com.spring.gwt.client.activities.home.HomeView;
import com.spring.gwt.client.activities.home.HomeViewImpl;

public class ClientFactoryImpl implements ClientFactory {
	private SimpleEventBus eventBus;
	private PlaceController placeController;
	
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
		return new HomeViewImpl();
	}

	@Override
	public CategoryView getCategoryView() {
		return new CategoryViewImpl();
	}

	@Override
	public ConsumableView getConsumableView() {
		return new ConsumableViewImpl();
	}

	@Override
	public ConsumableTypeView getConsumableTypeView() {
		return new ConsumableTypeViewImpl();
	}
}
