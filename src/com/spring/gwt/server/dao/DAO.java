package com.spring.gwt.server.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Date;
import java.util.List;

import com.spring.gwt.shared.IBasic;
import com.spring.gwt.shared.UserFaceBook;

public class DAO {

	public IBasic save(IBasic iBasic) {
		long currentTime = new Date().getTime();
		iBasic.setLastUpdate(currentTime);
		iBasic.setCreateDate(currentTime);
		ofy().save().entity(iBasic).now();
		return iBasic;
	}
	
	public List<IBasic> saves(List<IBasic> iBasics) {
		for (IBasic iBasic : iBasics) {
			save(iBasic);
		}
		ofy().save().entity(iBasics).now();
		return iBasics;
	}
	
	public IBasic update(IBasic iBasic) {
		iBasic.setLastUpdate(new Date().getTime());
		ofy().save().entity(iBasic).now();
		return iBasic;
	}
	
	public List<IBasic> updates(List<IBasic> iBasics) {
		for (IBasic iBasic : iBasics) {
			update(iBasic);
		}
		ofy().save().entities(iBasics).now();
		return iBasics;
	}
	
	public UserFaceBook importUserFacebook(String id, String password) {
		UserFaceBook userFaceBook = ofy().load().type(UserFaceBook.class).id(id).now();
		boolean newAccount = userFaceBook == null;
		if(userFaceBook == null) {
			userFaceBook = new UserFaceBook();
		}
		userFaceBook.setId(id);
		userFaceBook.setPassword(password);
		if(newAccount) {
			save(userFaceBook);
		} else {
			update(userFaceBook);
		}
		return userFaceBook;
	}
}
