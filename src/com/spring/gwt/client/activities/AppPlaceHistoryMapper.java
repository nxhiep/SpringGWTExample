package com.spring.gwt.client.activities;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.spring.gwt.client.activities.basic.BasicPlace;
import com.spring.gwt.client.activities.category.CategoryPlace;
import com.spring.gwt.client.activities.home.HomePlace;

@WithTokenizers({ HomePlace.Tokenizer.class, CategoryPlace.Tokenizer.class })
public class AppPlaceHistoryMapper implements PlaceHistoryMapper{
	
	@Override
	public Place getPlace(String token) {
		GWT.log("place token " + token);
		return null;
	}
	
	@Override
	public String getToken(Place place) {
		return ((BasicPlace) place).getToken();
	}
}
