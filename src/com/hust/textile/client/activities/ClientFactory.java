package com.hust.textile.client.activities;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.hust.textile.client.activities.category.CategoryView;
import com.hust.textile.client.activities.consumable.ConsumableView;
import com.hust.textile.client.activities.consumable.type.ConsumableTypeView;
import com.hust.textile.client.activities.home.HomeView;
import com.hust.textile.client.activities.process.ProcessView;
import com.hust.textile.client.activities.products.ProductsView;
import com.hust.textile.client.activities.products.details.ProductDetailsView;
import com.hust.textile.client.activities.settings.SettingsView;

public interface ClientFactory {
	PlaceController getPlaceController();
	EventBus getEventBus();
	HomeView getHomeView();
	CategoryView getCategoryView();
	ConsumableView getConsumableView();
	ConsumableTypeView getConsumableTypeView();
	ProductsView getProductsView();
	SettingsView getSettingsView();
	ProcessView getProgressView();
	ProductDetailsView getProductDetailsView();
}
