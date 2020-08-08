package com.hust.textile.server.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;

import com.hust.textile.shared.model.ProductInfo;

public class ProductDAO extends DAO {

	public List<ProductInfo> getAllProducts() {
		return new ArrayList<ProductInfo>(ofy().load().type(ProductInfo.class).list());
	}

	public ProductInfo getProductInfo(Long productId) {
		return ofy().load().type(ProductInfo.class).id(productId).now();
	}
	
}
