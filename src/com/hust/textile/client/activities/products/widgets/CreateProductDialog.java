package com.hust.textile.client.activities.products.widgets;

import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.textile.client.view.CKEditor;
import com.hust.textile.client.view.MyDialog;
import com.hust.textile.client.view.Toaster;
import com.hust.textile.shared.model.Product;

public class CreateProductDialog extends MyDialog {

	private static CreateProductDialogUiBinder uiBinder = GWT.create(CreateProductDialogUiBinder.class);

	interface CreateProductDialogUiBinder extends UiBinder<Widget, CreateProductDialog> {
	}
	
	@UiField TextBox nameBox;
	@UiField TextArea descriptionBox;
	@UiField FlowPanel imagesPanel;
	@UiField CKEditor noteEditor;
	private Product product;

	public CreateProductDialog() {
		this.getMainPanel().add(uiBinder.createAndBindUi(this));
	}
	
	public void show(Product product, String title, AsyncCallback<Void> callBack) {
		this.callBack = callBack;
		update(product);
		super.show(title, null, "Lưu", "Đóng", callBack);
	}

	private void update(Product product) {
		this.product = product;
		nameBox.setValue(product != null ? product.getName() : "");
		descriptionBox.setValue(product != null ? product.getDescription() : "");
		noteEditor.setContent(product != null ? product.getNote() : "");
	}
	
	public Product getProduct() {
		if(product == null) {
			product = new Product();
		}
		product.setName(nameBox.getValue());
		product.setDescription(descriptionBox.getValue());
		product.setNote(noteEditor.getContent());
		//TODO: set images
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
