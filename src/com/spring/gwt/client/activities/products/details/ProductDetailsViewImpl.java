package com.spring.gwt.client.activities.products.details;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.activities.basic.BasicViewImpl;

public class ProductDetailsViewImpl extends BasicViewImpl implements ProductDetailsView {

	private static ProductDetailsViewImplUiBinder uiBinder = GWT.create(ProductDetailsViewImplUiBinder.class);

	interface ProductDetailsViewImplUiBinder extends UiBinder<Widget, ProductDetailsViewImpl> {
	}
	
	public ProductDetailsViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		setActiveTab(this.getBasicLayout().getButtonProducts());
	}
	@Override
	public void refreshView() {
		super.refreshView();
	}
}
