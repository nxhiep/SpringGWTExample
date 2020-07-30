package com.hust.textile.client.activities.consumable;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hust.textile.client.activities.ClientFactory;
import com.hust.textile.client.activities.basic.BasicActivity;

public class ConsumableActivity extends BasicActivity {
	
	private ConsumableView view;
	
	public ConsumableActivity(Place place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getConsumableView();
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
