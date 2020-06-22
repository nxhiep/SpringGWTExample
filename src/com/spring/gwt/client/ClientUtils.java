package com.spring.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;

public class ClientUtils {

	public static String getStringValue(JSONObject object, String key) {
		if(object.get(key).isString() != null) {
			return object.get(key).isString().stringValue();
		}
		return "";
	}
	
	public static void log(String message) {
		GWT.log(message);
	}
}
