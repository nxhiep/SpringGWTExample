package com.spring.gwt.client.activities;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.spring.gwt.client.activities.category.CategoryView;
import com.spring.gwt.client.activities.consumable.ConsumableView;
import com.spring.gwt.client.activities.consumable.type.ConsumableTypeView;
import com.spring.gwt.client.activities.home.HomeView;
import com.spring.gwt.client.activities.products.ProductsView;
import com.spring.gwt.client.activities.progress.ProgressView;
import com.spring.gwt.client.activities.settings.SettingsView;

public interface ClientFactory {
	PlaceController getPlaceController();
	EventBus getEventBus();
	HomeView getHomeView();
	CategoryView getCategoryView();
	ConsumableView getConsumableView();
	ConsumableTypeView getConsumableTypeView();
	ProductsView getProductsView();
	SettingsView getSettingsView();
	ProgressView getProgressView();
}
