package com.hust.textile.client.activities;

import com.google.gwt.place.shared.Place;

public interface AsyncActivityMapper{
	void getActivity(Place place, ActivityCallbackHandler activityCallbackHandler);
}
