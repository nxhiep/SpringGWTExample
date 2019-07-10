package com.spring.gwt.client.activities;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.spring.gwt.client.activities.basic.BasicActivity;
import com.spring.gwt.client.activities.category.CategoryActivity;
import com.spring.gwt.client.activities.category.CategoryPlace;
import com.spring.gwt.client.activities.home.HomeActivity;
import com.spring.gwt.client.activities.home.HomePlace;

public class SplitAppActivityMapper implements AsyncActivityMapper {

	private ClientFactory clientFactory;

	public SplitAppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void getActivity(final Place place, final ActivityCallbackHandler activityCallbackHandler) {
		if (place instanceof HomePlace) {
			runAsync(activityCallbackHandler, new HomeActivity(place, clientFactory));
		} else if (place instanceof CategoryPlace) {
			runAsync(activityCallbackHandler, new CategoryActivity(place, clientFactory));
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
