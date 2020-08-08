package com.hust.textile.client.view;

import org.gwtbootstrap3.client.ui.base.button.CloseButton;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.hust.textile.client.ClientUtils;
import com.hust.textile.shared.Callback;

public class ImageItemPanel extends FlowPanel {
	
	private CloseButton closeButton = new CloseButton();
	private Image image = new Image();
	private boolean showDialog = true;
	public ImageItemPanel(String url) {
		this.setStyleName("image-item loading");
		image.setUrl(url);
		this.add(image);
		image.addErrorHandler(new ErrorHandler() {
			
			@Override
			public void onError(ErrorEvent arg0) {
				ImageItemPanel.this.removeStyleName("loading");
				ImageItemPanel.this.addStyleName("error");
			}
		});
		image.addLoadHandler(new LoadHandler() {
			
			@Override
			public void onLoad(LoadEvent arg0) {
				if(!arg0.getSource().toString().isEmpty()) {
					ImageItemPanel.this.removeStyleName("loading");
					ImageItemPanel.this.addStyleName("success");
				}
			}
		});
		image.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				if(!image.getElement().hasClassName("error") && showDialog) {
					new MyDialog().showImage("Ảnh", url);
				}
			}
		});
	}
	
	public void setUrl(String url) {
		this.addStyleName("loading");
		image.setUrl(url);
	}
	
	public Image getImage() {
		return image;
	}
	
	public String getUrl() {
		return image.getUrl();
	}
	
	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}
	
	public void addDeleteHandler(Callback<String> callback) {
		ClientUtils.log("addDeleteHandler url " + getUrl());
		this.add(closeButton);
		closeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				new MyDialog().showQuestion("Bạn có muốn xoá ảnh này?", new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void arg0) {
						callback.onCallback(getUrl());
					}
					
					@Override
					public void onFailure(Throwable arg0) {
					}
				});
			}
		});
	}
}
