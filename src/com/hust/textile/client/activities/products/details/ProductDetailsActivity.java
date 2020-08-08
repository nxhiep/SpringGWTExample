package com.hust.textile.client.activities.products.details;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hust.textile.client.ClientData;
import com.hust.textile.client.ClientUtils;
import com.hust.textile.client.RPCCall;
import com.hust.textile.client.activities.ClientFactory;
import com.hust.textile.client.activities.basic.BasicActivity;
import com.hust.textile.client.view.Toaster;
import com.hust.textile.shared.Callback;
import com.hust.textile.shared.model.ProductInfo;

public class ProductDetailsActivity extends BasicActivity {
	
	private ProductDetailsView view;
	private Long productId;
	private ProductInfo productInfo;
	
	public ProductDetailsActivity(Place place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}
	
	@Override
	protected void getParams(Place place) {
		super.getParams(place);
		ProductDetailsPlace productDetailsPlace = ((ProductDetailsPlace) place);
		productInfo = productDetailsPlace.getProductInfo();
		productId = productDetailsPlace.getProductId();
		ClientUtils.log("productId " + productId);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getProductDetailsView();
		super.start(panel, eventBus, view);
	}
	
	@Override
	protected void bind() {
		super.bind();
		view.getUploadPanel().setCompleteHandler(new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String url) {
				if(!productInfo.getImageUrls().contains(url)) {
					productInfo.getImageUrls().add(url);
					updateProductInfo();
					view.showProductInfo(productInfo, deleteImage());
				}
			}
			
			@Override
			public void onFailure(Throwable arg0) {}
		});
	}
	@Override
	protected void loadData() {
		super.loadData();
		if(productInfo == null) {
			loadProductInfo(productId);
		} else {
			view.showProductInfo(productInfo, deleteImage());
		}
	}

	private void loadProductInfo(Long productId) {
		new RPCCall<ProductInfo>() {

			@Override
			public void onFailure(Throwable arg0) {
			}

			@Override
			public void onSuccess(ProductInfo arg0) {
				if(arg0 != null) {
					productInfo = arg0;
					view.showProductInfo(productInfo, deleteImage());
				} else {
					Toaster.showError("Sản phẩm không tồn tại!");
				}
			}

			@Override
			protected void callService(AsyncCallback<ProductInfo> callback) {
				ClientData.DATA_SERVICE.getProductInfo(productId, callback);
			}
		}.retry(0, true);
	}
	
	private void updateProductInfo() {
		ClientData.save(productInfo, null);
	}
	
	private Callback<String> deleteImage() {
		return new Callback<String>() {
			
			@Override
			public void onCallback(String url) {
				ClientUtils.log("delete " + url + " ------ urls " + productInfo.getImageUrls().toString());
				productInfo.getImageUrls().remove(url);
				updateProductInfo();
				view.showProductInfo(productInfo, deleteImage());
			}
		};
	}
}
