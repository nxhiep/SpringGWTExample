package com.spring.gwt.client.activities;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.spring.gwt.client.activities.basic.BasicActivity;
import com.spring.gwt.client.activities.category.CategoryActivity;
import com.spring.gwt.client.activities.category.CategoryPlace;
import com.spring.gwt.client.activities.consumable.ConsumableActivity;
import com.spring.gwt.client.activities.consumable.ConsumablePlace;
import com.spring.gwt.client.activities.consumable.type.ConsumableTypeActivity;
import com.spring.gwt.client.activities.consumable.type.ConsumableTypePlace;
import com.spring.gwt.client.activities.home.HomeActivity;
import com.spring.gwt.client.activities.home.HomePlace;
import com.spring.gwt.client.activities.products.ProductsActivity;
import com.spring.gwt.client.activities.products.ProductsPlace;
import com.spring.gwt.client.activities.products.details.ProductDetailsActivity;
import com.spring.gwt.client.activities.products.details.ProductDetailsPlace;
import com.spring.gwt.client.activities.progress.ProgressActivity;
import com.spring.gwt.client.activities.progress.ProgressPlace;
import com.spring.gwt.client.activities.settings.SettingsActivity;
import com.spring.gwt.client.activities.settings.SettingsPlace;

public class AppActivityMapper implements AsyncActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void getActivity(final Place place, final ActivityCallbackHandler activityCallbackHandler) {
		if (place instanceof HomePlace) {
			runAsync(activityCallbackHandler, new HomeActivity(place, clientFactory));
		} else if (place instanceof CategoryPlace) {
			runAsync(activityCallbackHandler, new CategoryActivity(place, clientFactory));
		} else if (place instanceof ConsumablePlace) {
			runAsync(activityCallbackHandler, new ConsumableActivity(place, clientFactory));
		} else if (place instanceof ConsumableTypePlace) {
			runAsync(activityCallbackHandler, new ConsumableTypeActivity(place, clientFactory));
		} else if (place instanceof ProductsPlace) {
			runAsync(activityCallbackHandler, new ProductsActivity(place, clientFactory));
		} else if (place instanceof SettingsPlace) {
			runAsync(activityCallbackHandler, new SettingsActivity(place, clientFactory));
		} else if (place instanceof ProgressPlace) {
			runAsync(activityCallbackHandler, new ProgressActivity(place, clientFactory));
		} else if (place instanceof ProductDetailsPlace) {
			runAsync(activityCallbackHandler, new ProductDetailsActivity(place, clientFactory));
		}
	}

	private void runAsync(final ActivityCallbackHandler activityCallbackHandler, final BasicActivity activity) {
		GWT.runAsync(new RunAsyncCallback() {

			@Override
			public void onFailure(Throwable err) {
				Window.alert("Vui lòng tải lại trang này");
			}

			@Override
			public void onSuccess() {
				activityCallbackHandler.onRecieveActivity(activity);
			}
		});
	}
}
