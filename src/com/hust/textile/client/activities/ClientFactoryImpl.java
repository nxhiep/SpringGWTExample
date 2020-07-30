package com.hust.textile.client.activities;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.hust.textile.client.activities.category.CategoryView;
import com.hust.textile.client.activities.category.CategoryViewImpl;
import com.hust.textile.client.activities.consumable.ConsumableView;
import com.hust.textile.client.activities.consumable.ConsumableViewImpl;
import com.hust.textile.client.activities.consumable.type.ConsumableTypeView;
import com.hust.textile.client.activities.consumable.type.ConsumableTypeViewImpl;
import com.hust.textile.client.activities.home.HomeView;
import com.hust.textile.client.activities.home.HomeViewImpl;
import com.hust.textile.client.activities.process.ProcessView;
import com.hust.textile.client.activities.process.ProcessViewImpl;
import com.hust.textile.client.activities.products.ProductsView;
import com.hust.textile.client.activities.products.ProductsViewImpl;
import com.hust.textile.client.activities.products.details.ProductDetailsView;
import com.hust.textile.client.activities.products.details.ProductDetailsViewImpl;
import com.hust.textile.client.activities.settings.SettingsView;
import com.hust.textile.client.activities.settings.SettingsViewImpl;

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

	@Override
	public ProductsView getProductsView() {
		return new ProductsViewImpl();
	}

	@Override
	public SettingsView getSettingsView() {
		return new SettingsViewImpl();
	}

	@Override
	public ProcessView getProgressView() {
		return new ProcessViewImpl();
	}

	@Override
	public ProductDetailsView getProductDetailsView() {
		return new ProductDetailsViewImpl();
	}
}
