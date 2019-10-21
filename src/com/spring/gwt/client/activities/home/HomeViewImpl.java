package com.spring.gwt.client.activities.home;

import org.gwtbootstrap3.client.ui.Modal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.activities.basic.BasicViewImpl;

public class HomeViewImpl extends BasicViewImpl implements HomeView {

	private static BasicViewImplUiBinder uiBinder = GWT.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}
	
	@UiField Button buttonCategory, buttonCreateTestModel, buttonTestModal;
	@UiField HTML createTestModelStatusPanel;

	public HomeViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		buttonTestModal.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				new Modal().show();
			}
		});
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
	
	@Override
	public HasClickHandlers getButtonCategory() {
		return buttonCategory;
	}
	
	@Override
	public HasClickHandlers getButtonCreateTestModel() {
		return buttonCreateTestModel;
	}
	
	@Override
	public void updateStatusCreateTestModel(String status) {
		createTestModelStatusPanel.setHTML(status);
	}
}
