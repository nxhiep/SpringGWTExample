package com.hust.textile.shared.model;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.hust.textile.shared.Config;

@Entity
public class ProductInfo implements IBasic {
	@Ignore private static final long serialVersionUID = 1L;
	@Id private Long id;
	private String name = Config.TEXT_EMPTY;
	private String description = Config.TEXT_EMPTY;
	private String note = Config.TEXT_EMPTY;
	private List<String> imageUrls = new ArrayList<String>();
	private List<Long> deviceIds = new ArrayList<Long>();
	private List<String> diagramBlockUrls = new ArrayList<String>();
	private List<String> diagramAssemblyUrls = new ArrayList<String>();
	private List<String> diagramTechologicalProcessUrls = new ArrayList<String>();
	private List<String> tableTechologicalProcessUrls = new ArrayList<String>();
	private List<String> actionProcessUrls = new ArrayList<String>();
	@Index private String userId = Config.TEXT_EMPTY;
	@Index private Long lastUpdate;
	@Index private Long createDate;
	
	public ProductInfo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Long lastUpdate) {
		this.lastUpdate = lastUpdate;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public List<Long> getDeviceIds() {
		return deviceIds;
	}
	
	public void setDeviceIds(List<Long> deviceIds) {
		this.deviceIds = deviceIds;
	}

	public List<String> getDiagramBlockUrls() {
		return diagramBlockUrls;
	}

	public void setDiagramBlockUrls(List<String> diagramBlockUrls) {
		this.diagramBlockUrls = diagramBlockUrls;
	}

	public List<String> getDiagramAssemblyUrls() {
		return diagramAssemblyUrls;
	}

	public void setDiagramAssemblyUrls(List<String> diagramAssemblyUrls) {
		this.diagramAssemblyUrls = diagramAssemblyUrls;
	}
	
	public List<String> getActionProcessUrls() {
		return actionProcessUrls;
	}
	
	public void setActionProcessUrls(List<String> actionProcessUrls) {
		this.actionProcessUrls = actionProcessUrls;
	}

	public List<String> getDiagramTechologicalProcessUrls() {
		return diagramTechologicalProcessUrls;
	}

	public void setDiagramTechologicalProcessUrls(List<String> diagramTechologicalProcessUrls) {
		this.diagramTechologicalProcessUrls = diagramTechologicalProcessUrls;
	}

	public List<String> getTableTechologicalProcessUrls() {
		return tableTechologicalProcessUrls;
	}

	public void setTableTechologicalProcessUrls(List<String> tableTechologicalProcessUrls) {
		this.tableTechologicalProcessUrls = tableTechologicalProcessUrls;
	}
}
