package com.hust.textile.client.activities.products.widgets;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.textile.client.view.CKEditor;
import com.hust.textile.client.view.ImageItemPanel;
import com.hust.textile.client.view.MyDialog;
import com.hust.textile.client.view.Toaster;
import com.hust.textile.client.view.UploaderPanel;
import com.hust.textile.shared.model.ProductInfo;

public class CreateProductDialog extends MyDialog {

	private static CreateProductDialogUiBinder uiBinder = GWT.create(CreateProductDialogUiBinder.class);

	interface CreateProductDialogUiBinder extends UiBinder<Widget, CreateProductDialog> {
	}
	
	@UiField TextBox nameBox;
	@UiField TextArea descriptionBox;
	@UiField FlowPanel imagesPanel;
	@UiField CKEditor noteEditor;
	@UiField UploaderPanel uploadPanel;
	private ProductInfo product;
	private List<String> imagesUrl = new ArrayList<String>();

	public CreateProductDialog() {
		this.getMainPanel().add(uiBinder.createAndBindUi(this));
		uploadPanel.setCompleteHandler(new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String url) {
				if(!imagesUrl.contains(url)) {
					imagesUrl.add(url);
					ImageItemPanel imageItemPanel = new ImageItemPanel(url);
					imageItemPanel.setShowDialog(false);
					imageItemPanel.addStyleName("col-xs-6 col-sm-3");
					imagesPanel.add(imageItemPanel);
				}
			}
			
			@Override
			public void onFailure(Throwable arg0) {
			}
		});
	}
	
	public void show(ProductInfo product, String title, AsyncCallback<Void> callBack) {
		this.callBack = callBack;
		update(product);
		super.show(title, null, "Lưu", "Đóng", callBack);
	}

	private void update(ProductInfo product) {
		this.product = product;
		nameBox.setValue(product != null ? product.getName() : "");
		descriptionBox.setValue(product != null ? product.getDescription() : "");
		noteEditor.setContent(product != null ? product.getNote() : "");
	}
	
	public ProductInfo getProduct() {
		if(product == null) {
			product = new ProductInfo();
		}
		product.setName(nameBox.getValue());
		product.setDescription(descriptionBox.getValue());
		product.setNote(noteEditor.getContent());
		product.setImageUrls(imagesUrl);
		return product;
	}
	
	public boolean isValidated() {
		if(nameBox.getValue().isEmpty()) {
			Toaster.showError("Tên trống!");
			return false;
		}
		return true;
	}
}
