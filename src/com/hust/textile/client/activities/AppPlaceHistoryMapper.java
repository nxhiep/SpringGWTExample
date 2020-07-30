package com.hust.textile.client.activities;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.hust.textile.client.ClientUtils;
import com.hust.textile.client.activities.basic.BasicPlace;
import com.hust.textile.client.activities.category.CategoryPlace;
import com.hust.textile.client.activities.consumable.ConsumablePlace;
import com.hust.textile.client.activities.consumable.type.ConsumableTypePlace;
import com.hust.textile.client.activities.home.HomePlace;
import com.hust.textile.client.activities.process.ProcessPlace;
import com.hust.textile.client.activities.products.ProductsPlace;
import com.hust.textile.client.activities.products.details.ProductDetailsPlace;
import com.hust.textile.client.activities.settings.SettingsPlace;
import com.hust.textile.shared.Config;
import com.hust.textile.shared.PlaceToken;

public class AppPlaceHistoryMapper implements PlaceHistoryMapper {

	@Override
	public Place getPlace(String token) {
		Map<String, String> params = getMapURLSearchParams(token);
		if(token.contains(PlaceToken.CATEGORY_PLACE)) {
			Long id = -1l;
			if(params.containsKey(CategoryPlace.PARAM_ID)) {
				id = Long.parseLong(params.get(CategoryPlace.PARAM_ID));
			}
			return new CategoryPlace(id, params.get(CategoryPlace.PARAM_NAME));
		}
		if(token.contains(PlaceToken.CONSUMABLE_PLACE)) {
			return new ConsumablePlace();
		}
		if(token.contains(PlaceToken.CONSUMABLE_TYPE_PLACE)) {
			return new ConsumableTypePlace();
		}
		if(token.contains(PlaceToken.PRODUCTS_PLACE)) {
			return new ProductsPlace();
		}
		if(token.contains(PlaceToken.SETTINGS_PLACE)) {
			return new SettingsPlace();
		}
		if(token.contains(PlaceToken.PROCESS_PLACE)) {
			return new ProcessPlace();
		}
		if(token.contains(PlaceToken.PRODUCT_DETAILS_PLACE)) {
			Long id = Config.LONG_NULL;
			if(params.containsKey(ProductDetailsPlace.PARAM_PRODUCT_ID)) {
				id = Long.parseLong(params.get(ProductDetailsPlace.PARAM_PRODUCT_ID));
			}
			return new ProductDetailsPlace(id);
		}
		return new HomePlace();
	}

	@Override
	public String getToken(Place place) {
		return ((BasicPlace) place).getToken();
	}
	
	public static Map<String, String> getMapURLSearchParams(String url) {
		Map<String, String> map = new HashMap<String, String>();
		JavaScriptObject javaScriptObject = getURLSearchParams(url.substring(url.indexOf("?"), url.length()));
		JSONObject object = new JSONObject(javaScriptObject);
		for(String key : object.keySet()) {
			map.put(key, ClientUtils.getStringValue(object, key));
		}
		return map;
	}
	
	public static native JavaScriptObject getURLSearchParams(String url) /*-{
		var map = {};
		try {
			var mySearchParams = new $wnd.URLSearchParams(url);
			var entries = mySearchParams.entries();
			var result = entries.next();
			while (result && !result.done) {
				map[result.value[0]] = result.value[1];
				result = entries.next();
			}
		} catch(e){
			$wnd.console.log('getURLSearchParams error', e);
		}
		return map;
	}-*/;
}
