package com.spring.gwt.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class ClientUtils {

	public static String getStringValue(JSONObject object, String key) {
		if(object.get(key).isString() != null) {
			return object.get(key).isString().stringValue();
		}
		return "";
	}

	public static Widget getLoadingWidget() {
		HTML html = new HTML();
		html.setStyleName("lds-dual-ring");
		return html;
	}
	
	private static String titleDefault = Document.get().getTitle();

	public static void setTitlePage(String title) {
		Document.get().setTitle(title);
	}
	
	public static void setTitleDefault() {
		Document.get().setTitle(titleDefault);
	}
}
