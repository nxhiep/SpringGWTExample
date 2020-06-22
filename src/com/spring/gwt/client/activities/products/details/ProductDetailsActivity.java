package com.spring.gwt.client.activities.products.details;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.spring.gwt.client.activities.ClientFactory;
import com.spring.gwt.client.activities.basic.BasicActivity;
import com.spring.gwt.shared.model.Product;

public class ProductDetailsActivity extends BasicActivity {
	
	private ProductDetailsView view;
	private Long productId;
	private Product product;
	
	public ProductDetailsActivity(Place place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}
	
	@Override
	protected void getParams(Place place) {
		super.getParams(place);
		ProductDetailsPlace productDetailsPlace = ((ProductDetailsPlace) place);
		product = productDetailsPlace.getProduct();
		productId = productDetailsPlace.getProductId();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getProductDetailsView();
		super.start(panel, eventBus, view);
	}
	
	@Override
	protected void bind() {
		super.bind();
	}
	@Override
	protected void loadData() {
		super.loadData();
	}
}
