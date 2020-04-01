package com.spring.gwt.shared.model;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.spring.gwt.shared.Config;
import com.spring.gwt.shared.IBasic;

@Entity
public class Discussion implements IBasic {

	private static final long serialVersionUID = 1L;
	@Id private String id;
	@Index private Long parentId = Config.LONG_NULL;
	private String content = Config.TEXT_EMPTY;
	
	private int dataType = Config.COMMENT_DATA_TYPE_OTHER;
	private List<String> datas = new ArrayList<String>();
	
	private String userName = Config.TEXT_EMPTY;
	@Index private String userId = Config.TEXT_EMPTY;
	
	@Index private int status = Config.STATUS_PUBLIC;
	@Index private Long lastUpdate = Config.LONG_NULL;
	@Index private Long createDate = Config.LONG_NULL;
	
	@Ignore private boolean typing = false;
	
	public Discussion() {}
	
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
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<String> getDatas() {
		return datas;
	}
	
	public void setDatas(List<String> datas) {
		this.datas = datas;
	}
	
	public int getDataType() {
		return dataType;
	}
	
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setTyping(boolean typing) {
		this.typing = typing;
	}
	
	public boolean isTyping() {
		return typing;
	}
}
