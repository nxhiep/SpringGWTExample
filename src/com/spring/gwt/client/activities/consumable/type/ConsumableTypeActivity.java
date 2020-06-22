package com.spring.gwt.client.activities.consumable.type;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.spring.gwt.client.activities.ClientFactory;
import com.spring.gwt.client.activities.basic.BasicActivity;

public class ConsumableTypeActivity extends BasicActivity {
	
	private ConsumableTypeView view;
	
	public ConsumableTypeActivity(Place place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getConsumableTypeView();
		super.start(panel, eventBus, view);
	}
	
	@Override
	protected void bind() {
		super.bind();
	}
	
	@Override
	protected void loadData() {
		super.loadData();
	}
}
