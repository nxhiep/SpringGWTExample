package com.spring.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.spring.gwt.shared.TestModel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SpringGWTBasic implements EntryPoint {
	
	public void onModuleLoad() {
		GWT.log("Updating...");
		ClientData.DATA_SERVICE.updateTestModel(new AsyncCallback<TestModel>() {
			
			@Override
			public void onSuccess(TestModel result) {
				GWT.log("Update success TestModel name " + result.getName() + " - id " + result.getId());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Update error " + caught.getMessage());
			}
		});
	}
}
