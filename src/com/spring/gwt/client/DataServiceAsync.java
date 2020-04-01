package com.spring.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.spring.gwt.shared.model.TestModel;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface DataServiceAsync {

	void updateTestModel(AsyncCallback<TestModel> callback);
}
