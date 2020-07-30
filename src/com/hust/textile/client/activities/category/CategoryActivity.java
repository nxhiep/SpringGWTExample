package com.hust.textile.client.activities.category;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hust.textile.client.activities.ClientFactory;
import com.hust.textile.client.activities.basic.BasicActivity;
import com.hust.textile.client.activities.home.HomePlace;

public class CategoryActivity extends BasicActivity {
	
	private CategoryView view;
	private Long id;
	private String name;
	
	public CategoryActivity(Place place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}
	
	@Override
	protected void getParams(Place place) {
		super.getParams(place);
		id = ((CategoryPlace) place).getId();
		name = ((CategoryPlace) place).getName();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getCategoryView();
		super.start(panel, eventBus, view);
	}
	
	@Override
	protected void bind() {
		super.bind();
		addHandlerRegistration(view.getButtonHome().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.log("goTo HomePlace");
				goTo(new HomePlace());
			}
		}));
	}
	
	@Override
	protected void loadData() {
		super.loadData();
		GWT.log("id " + id + " --- name " + name);
	}
}
