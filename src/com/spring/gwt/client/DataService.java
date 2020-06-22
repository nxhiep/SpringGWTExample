package com.spring.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.spring.gwt.shared.model.UserInfo;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("data")
public interface DataService extends RemoteService {

	UserInfo loginFromSession();

	void logout();
}
