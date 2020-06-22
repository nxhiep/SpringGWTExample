package com.spring.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.spring.gwt.shared.model.UserInfo;

public class ClientData {
	public final static DataServiceAsync DATA_SERVICE = GWT.create(DataService.class);
	
	public static void prepareData() {
		
	}
	
	public static void loginFromSession(AsyncCallback<UserInfo> callback) {
		DATA_SERVICE.loginFromSession(new AsyncCallback<UserInfo>() {
			
			@Override
			public void onSuccess(UserInfo result) {
				LoginManager.setCurrentUser(result);
				if(callback != null) {
					callback.onSuccess(result);
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				LoginManager.setCurrentUser(null);
				if(callback != null) {
					callback.onFailure(caught);
				}
			}
		});
	}
}
