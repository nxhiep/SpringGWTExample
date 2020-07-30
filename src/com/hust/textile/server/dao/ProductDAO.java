package com.hust.textile.server.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;

import com.hust.textile.shared.model.Product;

public class ProductDAO extends DAO {

	public List<Product> getAllProducts() {
		return new ArrayList<Product>(ofy().load().type(Product.class).list());
	}
	
}
