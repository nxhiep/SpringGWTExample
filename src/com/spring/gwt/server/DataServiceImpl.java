package com.spring.gwt.server;

import com.spring.gwt.client.DataService;
import com.spring.gwt.server.dao.UserDAO;
import com.spring.gwt.shared.model.UserInfo;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class DataServiceImpl extends CustomRemoteServiceServlet implements DataService {

	protected UserDAO USER_DAO = new UserDAO();
	
	@Override
	public UserInfo loginFromSession() {
		return USER_DAO.loginFromSession(this.getThreadLocalRequest(), this.getThreadLocalResponse());
	}

	@Override
	public void logout() {
		USER_DAO.logout(this.getThreadLocalRequest(), this.getThreadLocalResponse());
	}
}
