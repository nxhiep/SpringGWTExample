package com.hust.textile.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.hust.textile.shared.Config;

@Entity
public class DeviceInfo implements IBasic {
	@Ignore private static final long serialVersionUID = 1L;
	@Id private Long id;
	@Index private String code = Config.TEXT_EMPTY;
	private String description = Config.TEXT_EMPTY;
	private String name = Config.TEXT_EMPTY;
	private double time = Config.LONG_NULL;
	@Index private Long parentId = Config.LONG_NULL;
	@Index private String userId = Config.TEXT_EMPTY;;
	@Index private Long lastUpdate;
	@Index private Long createDate;
	
	public DeviceInfo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	
	public Long getCreateDate() {
		return createDate;
	}

	@Override
	public void setLastUpdate(Long lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getLastUpdate() {
		return lastUpdate;
	}
}
