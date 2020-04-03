package com.spring.gwt.client.activities.view;

import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.ModalBody;
import org.gwtbootstrap3.client.ui.ModalFooter;
import org.gwtbootstrap3.client.ui.ModalHeader;
import org.gwtbootstrap3.client.ui.html.Span;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.shared.ConfirmCallback;
import com.spring.gwt.shared.IBasic;

public class HDialog extends Modal {
	
	protected ModalHeader modalHeader = new ModalHeader();
	protected ModalBody modalBody = new ModalBody();
	protected ModalFooter modalFooter = new ModalFooter();
	private ConfirmCallback callback;
	private IBasic iBasic;
	private Button cancelButton = new Button("Cancel");
	private Button okButton = new Button("Ok");
	
	public HDialog() {
		super();
		this.add(modalHeader);
		this.add(modalBody);
		this.add(modalFooter);
		modalFooter.add(okButton);
		modalFooter.add(new Span("&nbsp;&nbsp;&nbsp;"));
		modalFooter.add(cancelButton);
		handler();
	}
	
	protected void setWidget(Widget widget) {
		modalBody.clear();
		modalBody.add(widget);
	}
	
	private void handler() {
		okButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onConfirm();
			}
		});
		cancelButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onCancel();
			}
		});
	}
	
	protected void onConfirm() {
		if(callback != null) {
			callback.onConfirm(true);
		}
		hide();
	}
	
	protected void onCancel() {
		if(callback != null) {
			callback.onConfirm(false);
		}
		hide();
	}

	public void show(String title, IBasic iBasic, ConfirmCallback callback) {
		if(title == null || title.isEmpty()) {
			title = "Thông tin";
		}
		modalHeader.setTitle(title);
		this.callback = callback;
		if(iBasic != null) {
			updateInfo(iBasic);
		}
		show();
	}

	protected void updateInfo(IBasic iBasic) {
	}
	
	public IBasic getObject() {
		return iBasic;
	}
}
