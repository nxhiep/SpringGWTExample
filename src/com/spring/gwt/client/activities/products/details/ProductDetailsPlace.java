package com.spring.gwt.client.activities.products.details;

import com.spring.gwt.client.activities.basic.BasicPlace;
import com.spring.gwt.shared.Config;
import com.spring.gwt.shared.PlaceToken;
import com.spring.gwt.shared.model.Product;

public class ProductDetailsPlace extends BasicPlace {
	public static final String PARAM_PRODUCT_ID = "productId";
	private Long productId = Config.LONG_NULL;
	private Product product;
	public ProductDetailsPlace(Long productId) {
		super(PlaceToken.PRODUCT_DETAILS_PLACE + "?"+PARAM_PRODUCT_ID+"=" + productId);
	}
	
	public ProductDetailsPlace(Product product) {
		super(PlaceToken.PRODUCT_DETAILS_PLACE + "?"+PARAM_PRODUCT_ID+"=" + (product != null ? product.getId() : Config.LONG_NULL));
		this.product = product;
		if(product != null) {
			productId = product.getId();
		}
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public Product getProduct() {
		return product;
	}
}
