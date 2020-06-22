package com.spring.gwt.server;

import java.util.List;

import com.spring.gwt.client.DataService;
import com.spring.gwt.server.dao.ProductDAO;
import com.spring.gwt.server.dao.UserDAO;
import com.spring.gwt.shared.model.IBasic;
import com.spring.gwt.shared.model.Product;
import com.spring.gwt.shared.model.UserInfo;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class DataServiceImpl extends CustomRemoteServiceServlet implements DataService {

	protected UserDAO USER_DAO = new UserDAO();
	protected ProductDAO PRODUCT_DAO = new ProductDAO();
	
	@Override
	public IBasic save(IBasic iBasic) {
		return USER_DAO.save(iBasic);
	}
	
	@Override
	public List<IBasic> saves(List<IBasic> iBasics) {
		return USER_DAO.saves(iBasics);
	}
	
	@Override
	public void delete(IBasic iBasic) {
		USER_DAO.delete(iBasic);
	}
	
	@Override
	public void deletes(List<IBasic> iBasics) {
		USER_DAO.deletes(iBasics);
	}
	
	@Override
	public UserInfo loginFromSession() {
		return USER_DAO.loginFromSession(this.getThreadLocalRequest(), this.getThreadLocalResponse());
	}

	@Override
	public void logout() {
		USER_DAO.logout(this.getThreadLocalRequest(), this.getThreadLocalResponse());
	}
	
	@Override
	public List<Product> getAllProducts() {
		return PRODUCT_DAO.getAllProducts();
	}
}
