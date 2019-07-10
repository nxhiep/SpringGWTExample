package com.spring.gwt.shared;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class UserInfo implements IBasic {

	private static final long serialVersionUID = 1L;
	@Id private String id;
	@Index private String name;
	@Index private Long lastUpdate;
	@Index private Long createDate;
	
	public UserInfo() {}
	
	@Override
	public String Id() {
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
}
