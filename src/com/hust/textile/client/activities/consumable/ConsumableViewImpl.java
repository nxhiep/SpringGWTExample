package com.hust.textile.client.activities.consumable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.hust.textile.client.activities.basic.BasicViewImpl;

public class ConsumableViewImpl extends BasicViewImpl implements ConsumableView {

	private static BasicViewImplUiBinder uiBinder = GWT.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, ConsumableViewImpl> {
	}

	public ConsumableViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
}
