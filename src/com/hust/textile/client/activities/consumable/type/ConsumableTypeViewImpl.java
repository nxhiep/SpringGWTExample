package com.hust.textile.client.activities.consumable.type;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.hust.textile.client.activities.basic.BasicViewImpl;

public class ConsumableTypeViewImpl extends BasicViewImpl implements ConsumableTypeView {

	private static BasicViewImplUiBinder uiBinder = GWT.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, ConsumableTypeViewImpl> {
	}
	
	public ConsumableTypeViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
}
