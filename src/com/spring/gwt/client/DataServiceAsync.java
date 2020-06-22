package com.spring.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.spring.gwt.shared.model.ActionInfo;
import com.spring.gwt.shared.model.ActivityInfo;
import com.spring.gwt.shared.model.IBasic;
import com.spring.gwt.shared.model.Product;
import com.spring.gwt.shared.model.UserInfo;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface DataServiceAsync {

	void loginFromSession(AsyncCallback<UserInfo> callback);

	void logout(AsyncCallback<Void> callback);

	void save(IBasic iBasic, AsyncCallback<IBasic> callback);

	void saves(List<IBasic> iBasics, AsyncCallback<List<IBasic>> callback);

	void delete(IBasic iBasic, AsyncCallback<Void> callback);

	void deletes(List<IBasic> iBasics, AsyncCallback<Void> callback);

	void getAllProducts(AsyncCallback<List<Product>> callback);

	void getActivities(AsyncCallback<List<ActivityInfo>> callback);

	void getActions(AsyncCallback<List<ActionInfo>> callback);
}
