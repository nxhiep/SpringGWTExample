package com.spring.gwt.client.activities.home;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.activities.basic.BasicViewImpl;
import com.spring.gwt.client.activities.home.widgets.CreateMealPopup;
import com.spring.gwt.client.activities.view.BasicSearchBox;
import com.spring.gwt.shared.model.MealInfo;

public class HomeViewImpl extends BasicViewImpl implements HomeView {

	private static BasicViewImplUiBinder uiBinder = GWT.create(BasicViewImplUiBinder.class);

	interface BasicViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}
	
	@UiField BasicSearchBox searchBox;
	@UiField Button addMealButton;
	@UiField FlowPanel contentPanel;

	private CreateMealPopup createMealPopup;
	
	public HomeViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		addMealButton.setHTML("<i class=\"far fa-plus\"></i>");
		setTitlePage("Home");
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}

	@Override
	public void showMeals(List<MealInfo> mealInfos) {
		contentPanel.clear();
		if(mealInfos == null || mealInfos.isEmpty()) {
			contentPanel.add(new HTML("Danh sách trống!"));
			return;
		}
		for (MealInfo mealInfo : mealInfos) {
			contentPanel.add(new HTML(mealInfo.getName()));
		}
	}
	
	@Override
	public Button getAddMealButton() {
		return addMealButton;
	}
	
	@Override
	public CreateMealPopup getCreateMealPopup() {
		if(createMealPopup == null) {
			createMealPopup = new CreateMealPopup();
		}
		return createMealPopup;
	}
}
