package com.spring.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.spring.gwt.shared.IBasic;
import com.spring.gwt.shared.model.MealInfo;
import com.spring.gwt.shared.model.TestModel;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("data")
public interface DataService extends RemoteService {

	TestModel updateTestModel();

	List<MealInfo> getMeals();

	IBasic save(IBasic iBasic);

	List<IBasic> saves(List<IBasic> iBasics);

	IBasic update(IBasic iBasic);

	List<IBasic> updates(List<IBasic> iBasics);
}
