package com.hust.textile.client.activities.products.widgets;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.hust.textile.client.view.ImageItemPanel;
import com.hust.textile.client.view.UploaderPanel;
import com.hust.textile.shared.model.ProductInfo;

public class ActionProcessPanel extends FlowPanel {
	
	private UploaderPanel uploaderPanel = new UploaderPanel();
	private FlowPanel imagesPanel = new FlowPanel();
	
	private ProductInfo productInfo;
	public ActionProcessPanel(ProductInfo productInfo) {
		this.productInfo = productInfo;
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("row");
		this.add(flowPanel);
		flowPanel.add(uploaderPanel);
		flowPanel.add(imagesPanel);
		imagesPanel.clear();
		uploaderPanel.setCompleteHandler(new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String url) {
				imagesPanel.add(new ImageItemPanel(url));
			}
			
			@Override
			public void onFailure(Throwable arg0) {
			}
		});
	}
	
	public ProductInfo getProductInfo() {
		return productInfo;
	}
}
