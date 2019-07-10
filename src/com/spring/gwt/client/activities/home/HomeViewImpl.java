package com.spring.gwt.client.activities.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.activities.basic.BasicViewImpl;

public class HomeViewImpl extends BasicViewImpl implements HomeView {

	private static BasicViewImplUiBinder uiBinder = GWT.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}
	
	@UiField Button buttonCategory;

	public HomeViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
	
	@UiHandler("buttonCategory")
	public void clickButtonCategory(ClickEvent event) {
		eventBus.fireEvent(event);
	}
	
	@Override
	public Button getButtonCategory() {
		return buttonCategory;
	}
}
