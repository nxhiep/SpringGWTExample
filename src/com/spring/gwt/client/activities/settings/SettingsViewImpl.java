package com.spring.gwt.client.activities.settings;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.activities.basic.BasicViewImpl;

public class SettingsViewImpl extends BasicViewImpl implements SettingsView {

	private static BasicViewImplUiBinder uiBinder = GWT.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, SettingsViewImpl> {
	}
	
	public SettingsViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		setActiveTab(this.getBasicLayout().getButtonSettings());
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
}
