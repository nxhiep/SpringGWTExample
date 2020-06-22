package com.spring.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.spring.gwt.shared.model.IBasic;
import com.spring.gwt.shared.model.Product;
import com.spring.gwt.shared.model.UserInfo;

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
}
