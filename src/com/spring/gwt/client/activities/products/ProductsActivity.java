package com.spring.gwt.client.activities.products;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.spring.gwt.client.ClientData;
import com.spring.gwt.client.activities.ClientFactory;
import com.spring.gwt.client.activities.basic.BasicActivity;
import com.spring.gwt.client.activities.products.details.ProductDetailsPlace;
import com.spring.gwt.client.activities.products.widgets.CreateProductDialog;
import com.spring.gwt.client.event.ActionEvent;
import com.spring.gwt.client.event.ActionEvent.Action;
import com.spring.gwt.client.event.ActionEventHandler;
import com.spring.gwt.client.view.MyDialog;
import com.spring.gwt.shared.model.IBasic;
import com.spring.gwt.shared.model.Product;

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
					showUpdateProduct((Product) event.getIBasic());
				} else if(Action.VIEW.equals(event.getAction())) {
					goTo(new ProductDetailsPlace((Product) event.getIBasic()));
				} else if(Action.DELETE.equals(event.getAction())) {
					deleteObject(event.getIBasic());
				}
			}
		}));
	}
	
	protected void showUpdateProduct(Product product) {
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
		ClientData.DATA_SERVICE.getAllProducts(new AsyncCallback<List<Product>>() {
			
			@Override
			public void onSuccess(List<Product> result) {
				view.view(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
}
