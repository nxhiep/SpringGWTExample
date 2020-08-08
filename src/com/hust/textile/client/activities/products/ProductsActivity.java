package com.hust.textile.client.activities.products;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hust.textile.client.ClientData;
import com.hust.textile.client.activities.ClientFactory;
import com.hust.textile.client.activities.basic.BasicActivity;
import com.hust.textile.client.activities.products.details.ProductDetailsPlace;
import com.hust.textile.client.activities.products.widgets.CreateProductDialog;
import com.hust.textile.client.event.ActionEvent;
import com.hust.textile.client.event.ActionEventHandler;
import com.hust.textile.client.event.ActionEvent.Action;
import com.hust.textile.client.view.MyDialog;
import com.hust.textile.shared.model.IBasic;
import com.hust.textile.shared.model.ProductInfo;

public class ProductsActivity extends BasicActivity {
	
	private ProductsView view;
	
	public ProductsActivity(Place place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}
	
	@Override
	protected void getParams(Place place) {
		super.getParams(place);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getProductsView();
		super.start(panel, eventBus, view);
	}
	
	@Override
	protected void bind() {
		super.bind();
		addHandlerRegistration(view.getButtonAddProduct().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				showUpdateProduct(null);
			}
		}));
		
		addHandlerRegistration(eventBus.addHandler(ActionEvent.TYPE, new ActionEventHandler() {
			
			@Override
			public void onEvent(ActionEvent event) {
				if(Action.EDIT.equals(event.getAction())) {
					showUpdateProduct((ProductInfo) event.getIBasic());
				} else if(Action.VIEW.equals(event.getAction())) {
					goTo(new ProductDetailsPlace((ProductInfo) event.getIBasic()));
				} else if(Action.DELETE.equals(event.getAction())) {
					deleteObject(event.getIBasic());
				}
			}
		}));
	}
	
	protected void showUpdateProduct(ProductInfo product) {
		CreateProductDialog createProductDialog = view.getCreateProductDialog();
		createProductDialog.show(product, product != null ? "Sửa " + product.getName() : "Thêm sản phẩm", 
				new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				if(createProductDialog.isValidated()) {
					updateObject(createProductDialog.getProduct());
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				createProductDialog.hide();
			}
		});
	}

	protected void deleteObject(IBasic iBasic) {
		MyDialog myDialog = new MyDialog();
		myDialog.show("Bạn muốn xoá sản phẩm", null, "Đồng ý", "Huỷ", new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				ClientData.delete(iBasic, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						loadData();
						myDialog.hide();
					}
					
					@Override
					public void onFailure(Throwable caught) {
						myDialog.hide();
					}
				});
			}
			
			@Override
			public void onFailure(Throwable caught) {
				myDialog.hide();
			}
		});
	}

	protected void updateObject(IBasic iBasic) {
		ClientData.save(iBasic, new AsyncCallback<IBasic>() {
			
			@Override
			public void onSuccess(IBasic result) {
				loadData();
				view.getCreateProductDialog().hide();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				view.getCreateProductDialog().hide();
			}
		});
	}
	
	@Override
	protected void loadData() {
		super.loadData();
		ClientData.DATA_SERVICE.getAllProducts(new AsyncCallback<List<ProductInfo>>() {
			
			@Override
			public void onSuccess(List<ProductInfo> result) {
				view.view(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
}
