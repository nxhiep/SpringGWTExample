package com.spring.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.spring.gwt.shared.IBasic;
import com.spring.gwt.shared.model.MealInfo;
import com.spring.gwt.shared.model.TestModel;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface DataServiceAsync {

	void updateTestModel(AsyncCallback<TestModel> callback);

	void getMeals(AsyncCallback<List<MealInfo>> asyncCallback);

	void save(IBasic iBasic, AsyncCallback<IBasic> callback);

	void saves(List<IBasic> iBasics, AsyncCallback<List<IBasic>> callback);

	void update(IBasic iBasic, AsyncCallback<IBasic> callback);

	void updates(List<IBasic> iBasics, AsyncCallback<List<IBasic>> callback);
}
