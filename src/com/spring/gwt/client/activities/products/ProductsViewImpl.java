package com.spring.gwt.client.activities.products;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.activities.basic.BasicViewImpl;

public class ProductsViewImpl extends BasicViewImpl implements ProductsView {

	private static BasicViewImplUiBinder uiBinder = GWT.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, ProductsViewImpl> {
	}
	
	public ProductsViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		setActiveTab(this.getBasicLayout().getButtonProducts());
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
}
