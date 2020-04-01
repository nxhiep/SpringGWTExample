package com.spring.gwt.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.spring.gwt.shared.Config;
import com.spring.gwt.shared.IBasic;

@Entity
public class UserInfo implements IBasic {

	private static final long serialVersionUID = 1L;
	@Id private String id;
	@Index private String account = Config.TEXT_EMPTY;
	@Index private String name = Config.TEXT_EMPTY;
	private String facebookId = Config.TEXT_EMPTY;
	private String password = Config.TEXT_EMPTY;
	private int gender = Config.GENDER_UNSET;
	@Index private Long lastUpdate = Config.LONG_NULL;
	@Index private Long createDate = Config.LONG_NULL;
	
	public UserInfo() {}
	
	@Override
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setLastUpdate(Long lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Long getLastUpdate() {
		return lastUpdate;
	}
	
	@Override
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public Long getCreateDate() {
		return createDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
}
