package com.hust.textile.client.activities.category;

import com.hust.textile.client.activities.basic.BasicPlace;
import com.hust.textile.shared.PlaceToken;

public class CategoryPlace extends BasicPlace {
	
	public static final String PARAM_ID = "id";
	public static final String PARAM_NAME = "name";
	private Long id;
	private String name;
	
	public CategoryPlace(Long id) {
		this(id, null);
	}
	
	public CategoryPlace(Long id, String name) {
		super(PlaceToken.CATEGORY_PLACE + "?"+PARAM_ID+"=" + id + (name != null && !name.isEmpty() ? "&" + PARAM_NAME + "=" + name : ""));
		setId(id);
		setName(name);
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
