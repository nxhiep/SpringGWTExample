package com.hust.textile.client.activities.products.details;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.hust.textile.client.activities.basic.BasicViewImpl;
import com.hust.textile.client.activities.products.widgets.DevicesPanel;
import com.hust.textile.client.view.ImageItemPanel;
import com.hust.textile.client.view.UploaderPanel;
import com.hust.textile.shared.Callback;
import com.hust.textile.shared.model.ProductInfo;

public class ProductDetailsViewImpl extends BasicViewImpl implements ProductDetailsView {

	private static ProductDetailsViewImplUiBinder uiBinder = GWT.create(ProductDetailsViewImplUiBinder.class);

	interface ProductDetailsViewImplUiBinder extends UiBinder<Widget, ProductDetailsViewImpl> {
	}
	
	@UiField HTML nameHTML;
	@UiField DevicesPanel devicesPanel;
	@UiField FlowPanel imagesPanel;
	@UiField UploaderPanel uploadPanel;
	
	public ProductDetailsViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		setActiveTab(this.getBasicLayout().getButtonProducts());
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
	
	@Override
	public void showProductInfo(ProductInfo productInfo, Callback<String> callback) {
		nameHTML.setHTML(productInfo.getName());
		imagesPanel.clear();
		for(String imageUrl : productInfo.getImageUrls()){
			ImageItemPanel imageItemPanel = new ImageItemPanel(imageUrl);
			imageItemPanel.addStyleName("col-xs-6 col-sm-3");
			imagesPanel.add(imageItemPanel);
			imageItemPanel.addDeleteHandler(callback);
		}
	}
	
	@Override
	public UploaderPanel getUploadPanel() {
		return uploadPanel;
	}
}
