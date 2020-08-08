package com.hust.textile.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.i18n.client.constants.TimeZoneConstants;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.hust.textile.shared.Config;

public class ClientUtils {

	private static DateTimeFormat dateFormat;
	public static String getStringValue(JSONObject object, String key) {
		if(object.get(key).isString() != null) {
			return object.get(key).isString().stringValue();
		}
		return "";
	}
	
	public static void log(String message) {
		GWT.log(message);
	}
	
	public static String formatDate(Long time, String patternFormat) {
		if (time == null || time <= Config.LONG_NULL)
			return "-";
		if(patternFormat == null) {
			patternFormat = Config.DATE_FORMAT_DATE;
		}
		dateFormat = DateTimeFormat.getFormat(patternFormat);
		Date date = new Date();
		date.setTime(time);
		return dateFormat.format(date, ClientUtils.getTimeZone());
	}
	
	public static TimeZone getTimeZone() {
		return  TimeZone.createTimeZone(((TimeZoneConstants) GWT.create(TimeZoneConstants.class)).asiaSaigon());
	}

	public static boolean isMobileWeb() {
		return Window.getClientWidth() <= 768;
	}

	public static boolean isLocalTestMode() {
		String href = Window.Location.getHref();
		return href.contains("127.0.0.1") || href.contains("localhost");
	}

	public static void importCSS(String cssUrl) {
		LinkElement linkElement = Document.get().createLinkElement();
		linkElement.setHref(cssUrl);
		linkElement.setRel("stylesheet");
		linkElement.setType("text/css");
		DOM.appendChild(Document.get().getHead(), linkElement);
	}
}
