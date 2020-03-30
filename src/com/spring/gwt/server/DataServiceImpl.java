package com.spring.gwt.server;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Date;

import com.googlecode.objectify.ObjectifyService;
import com.spring.gwt.client.DataService;
import com.spring.gwt.shared.TestModel;
import com.spring.gwt.shared.UserFaceBook;
import com.spring.gwt.shared.UserInfo;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class DataServiceImpl extends CustomRemoteServiceServlet implements DataService {
	
	static {
		ObjectifyService.register(TestModel.class);
		ObjectifyService.register(UserInfo.class);
		ObjectifyService.register(UserFaceBook.class);
	}
	
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
}
