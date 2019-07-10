package com.spring.gwt.client.activities.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.spring.gwt.client.ClientData;
import com.spring.gwt.client.activities.ClientFactory;
import com.spring.gwt.client.activities.basic.BasicActivity;
import com.spring.gwt.client.activities.category.CategoryPlace;
import com.spring.gwt.shared.TestModel;

public class HomeActivity extends BasicActivity {
	
	private HomeView view;
	
	public HomeActivity(Place place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}
	
	@Override
	protected void getParams(Place place) {
		super.getParams(place);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getHomeView();
		super.start(panel, eventBus, view);
	}
	
	@Override
	protected void bind() {
		super.bind();
		addHandlerRegistration(view.getButtonCategory().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.log("goTo CategoryPlace");
				goTo(new CategoryPlace(12345l, "category"));
			}
		}));
		addHandlerRegistration(view.getButtonCreateTestModel().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				view.updateStatusCreateTestModel("Creating TestModel ...");
				ClientData.DATA_SERVICE.updateTestModel(new AsyncCallback<TestModel>() {
					
					@Override
					public void onSuccess(TestModel result) {
						view.updateStatusCreateTestModel("Created TestModel id = " + result.getId());
					}
					
					@Override
					public void onFailure(Throwable caught) {
						view.updateStatusCreateTestModel("Error: " + caught.getMessage());
					}
				});
			}
		}));
	}
	
	@Override
	protected void loadData() {
		super.loadData();
	}
}
