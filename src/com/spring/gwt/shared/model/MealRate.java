package com.spring.gwt.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.spring.gwt.shared.Config;
import com.spring.gwt.shared.IBasic;

@Entity
public class MealRate implements IBasic {

	private static final long serialVersionUID = 1L;
	@Id private Long id;
	@Index private String name = Config.TEXT_EMPTY;
	@Index private String shortDescription = Config.TEXT_EMPTY;
	private String description = Config.TEXT_EMPTY;
	@Index private String userId = Config.TEXT_EMPTY;
	@Index private Long lastUpdate = Config.LONG_NULL;
	@Index private Long createDate = Config.LONG_NULL;
	
	public MealRate() {}
	
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
