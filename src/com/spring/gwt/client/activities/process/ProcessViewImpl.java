package com.spring.gwt.client.activities.process;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.activities.basic.BasicViewImpl;

public class ProcessViewImpl extends BasicViewImpl implements ProcessView {

	private static ProcessViewImplUiBinder uiBinder = GWT.create(ProcessViewImplUiBinder.class);

	interface ProcessViewImplUiBinder extends UiBinder<Widget, ProcessViewImpl> {
	}
	
	public ProcessViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		setActiveTab(this.getBasicLayout().getButtonProcess());
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
}
