package com.spring.gwt.client.activities.products;

import java.util.List;

import org.gwtbootstrap3.client.ui.Button;

import com.spring.gwt.client.activities.basic.BasicView;
import com.spring.gwt.client.activities.products.widgets.CreateProductDialog;
import com.spring.gwt.shared.model.Product;

public interface ProductsView extends BasicView {

	CreateProductDialog getCreateProductDialog();

	Button getButtonAddProduct();

	void view(List<Product> products);
}
