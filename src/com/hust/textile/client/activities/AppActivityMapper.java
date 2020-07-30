package com.hust.textile.client.activities;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.hust.textile.client.activities.basic.BasicActivity;
import com.hust.textile.client.activities.category.CategoryActivity;
import com.hust.textile.client.activities.category.CategoryPlace;
import com.hust.textile.client.activities.consumable.ConsumableActivity;
import com.hust.textile.client.activities.consumable.ConsumablePlace;
import com.hust.textile.client.activities.consumable.type.ConsumableTypeActivity;
import com.hust.textile.client.activities.consumable.type.ConsumableTypePlace;
import com.hust.textile.client.activities.home.HomeActivity;
import com.hust.textile.client.activities.home.HomePlace;
import com.hust.textile.client.activities.process.ProcessActivity;
import com.hust.textile.client.activities.process.ProcessPlace;
import com.hust.textile.client.activities.products.ProductsActivity;
import com.hust.textile.client.activities.products.ProductsPlace;
import com.hust.textile.client.activities.products.details.ProductDetailsActivity;
import com.hust.textile.client.activities.products.details.ProductDetailsPlace;
import com.hust.textile.client.activities.settings.SettingsActivity;
import com.hust.textile.client.activities.settings.SettingsPlace;

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
		} else if (place instanceof ProcessPlace) {
			runAsync(activityCallbackHandler, new ProcessActivity(place, clientFactory));
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
