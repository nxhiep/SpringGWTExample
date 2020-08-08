package com.hust.textile.client.activities.products.details;

import com.hust.textile.client.activities.basic.BasicPlace;
import com.hust.textile.shared.Config;
import com.hust.textile.shared.PlaceToken;
import com.hust.textile.shared.model.ProductInfo;

public class ProductDetailsPlace extends BasicPlace {
	public static final String PARAM_PRODUCT_ID = "productId";
	private Long productId = Config.LONG_NULL;
	private ProductInfo productInfo;
	public ProductDetailsPlace(Long productId) {
		super(PlaceToken.PRODUCT_DETAILS_PLACE + "?"+PARAM_PRODUCT_ID+"=" + productId);
		this.productId = productId;
	}
	
	public ProductDetailsPlace(ProductInfo productInfo) {
		super(PlaceToken.PRODUCT_DETAILS_PLACE + "?"+PARAM_PRODUCT_ID+"=" + (productInfo != null ? productInfo.getId() : Config.LONG_NULL));
		this.productInfo = productInfo;
		if(productInfo != null) {
			productId = productInfo.getId();
		}
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public ProductInfo getProductInfo() {
		return productInfo;
	}
}
