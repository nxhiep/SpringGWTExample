package com.hust.textile.client.activities.products.details;

import com.hust.textile.client.activities.basic.BasicView;
import com.hust.textile.client.view.UploaderPanel;
import com.hust.textile.shared.Callback;
import com.hust.textile.shared.model.ProductInfo;

public interface ProductDetailsView extends BasicView {

	UploaderPanel getUploadPanel();

	void showProductInfo(ProductInfo productInfo, Callback<String> callback);
}
