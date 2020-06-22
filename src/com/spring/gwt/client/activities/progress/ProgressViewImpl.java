package com.spring.gwt.client.activities.progress;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.activities.basic.BasicViewImpl;

public class ProgressViewImpl extends BasicViewImpl implements ProgressView {

	private static BasicViewImplUiBinder uiBinder = GWT.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, ProgressViewImpl> {
	}
	
	public ProgressViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		setActiveTab(this.getBasicLayout().getButtonProcess());
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
}
