package com.spring.gwt.server;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spring.gwt.client.DataService;
import com.spring.gwt.shared.IBasic;
import com.spring.gwt.shared.model.MealInfo;
import com.spring.gwt.shared.model.TestModel;

@SuppressWarnings("serial")
public class DataServiceImpl extends CustomRemoteServiceServlet implements DataService {
	
	@Override
	public TestModel updateTestModel() { 
		TestModel testModel = new TestModel();
		testModel.setName("TestModel1");
		long currentTime = new Date().getTime();
		testModel.setCreateDate(currentTime);
		testModel.setLastUpdate(currentTime);
		ofy().save().entity(testModel).now();
		return testModel;
	}

	@Override
	public IBasic save(IBasic iBasic) {
		long currentTime = new Date().getTime();
		iBasic.setLastUpdate(currentTime);
		iBasic.setCreateDate(currentTime);
		ofy().save().entity(iBasic).now();
		return iBasic;
	}
	
	@Override
	public List<IBasic> saves(List<IBasic> iBasics) {
		long currentTime = new Date().getTime();
		for (IBasic iBasic : iBasics) {
			iBasic.setLastUpdate(currentTime);
			iBasic.setCreateDate(currentTime);
		}
		ofy().save().entity(iBasics).now();
		return iBasics;
	}
	
	@Override
	public IBasic update(IBasic iBasic) {
		iBasic.setLastUpdate(new Date().getTime());
		ofy().save().entity(iBasic).now();
		return iBasic;
	}
	
	@Override
	public List<IBasic> updates(List<IBasic> iBasics) {
		long currentTime = new Date().getTime();
		for (IBasic iBasic : iBasics) {
			iBasic.setLastUpdate(currentTime);
		}
		ofy().save().entities(iBasics).now();
		return iBasics;
	}
	
	@Override
	public List<MealInfo> getMeals() {
		return new ArrayList<MealInfo>(ofy().load().type(MealInfo.class).list());
	}
	
}
