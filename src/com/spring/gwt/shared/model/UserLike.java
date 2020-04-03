package com.spring.gwt.shared.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.spring.gwt.shared.Config;
import com.spring.gwt.shared.IBasic;

@Entity
public class UserLike implements IBasic {

	private static final long serialVersionUID = 1L;
	@Id private Long id;
	@Index private String userId = Config.TEXT_EMPTY;
	@Index private String parentId = Config.TEXT_EMPTY; // userId, mealId, discussionId
	@Index private int type = Config.USER_LIKE_TYPE_OTHER;
	@Index private int status = Config.USER_LIKE_STATUS_LIKE;
	@Index private Long lastUpdate = Config.LONG_NULL;
	@Index private Long createDate = Config.LONG_NULL;
	
	public UserLike() {}
	
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
