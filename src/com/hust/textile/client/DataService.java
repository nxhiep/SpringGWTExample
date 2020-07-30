package com.hust.textile.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.textile.shared.model.ActionInfo;
import com.hust.textile.shared.model.ActivityInfo;
import com.hust.textile.shared.model.IBasic;
import com.hust.textile.shared.model.Product;
import com.hust.textile.shared.model.UserInfo;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("data")
public interface DataService extends RemoteService {

	UserInfo loginFromSession();

	void logout();

	IBasic save(IBasic iBasic);

	List<IBasic> saves(List<IBasic> iBasics);

	void delete(IBasic iBasic);

	void deletes(List<IBasic> iBasics);

	List<Product> getAllProducts();

	List<ActivityInfo> getActivities();

	List<ActionInfo> getActions();
}
