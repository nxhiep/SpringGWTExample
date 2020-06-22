package com.spring.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.spring.gwt.shared.model.UserInfo;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface DataServiceAsync {

	void loginFromSession(AsyncCallback<UserInfo> callback);

	void logout(AsyncCallback<Void> callback);
}
