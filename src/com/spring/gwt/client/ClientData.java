package com.spring.gwt.client;

import com.google.gwt.core.client.GWT;

public class ClientData {
	public final DataServiceAsync DATA_SERVICE = GWT.create(DataService.class);
}
