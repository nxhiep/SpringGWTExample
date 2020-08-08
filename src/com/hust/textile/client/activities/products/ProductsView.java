package com.hust.textile.client.activities.products;

import java.util.List;

import org.gwtbootstrap3.client.ui.Button;

import com.hust.textile.client.activities.basic.BasicView;
import com.hust.textile.client.activities.products.widgets.CreateProductDialog;
import com.hust.textile.shared.model.ProductInfo;

public interface ProductsView extends BasicView {

	CreateProductDialog getCreateProductDialog();

	Button getButtonAddProduct();

	void view(List<ProductInfo> products);
}
