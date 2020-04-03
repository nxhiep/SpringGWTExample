package com.spring.gwt.client.activities.home.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.activities.view.HDialog;
import com.spring.gwt.shared.IBasic;
import com.spring.gwt.shared.model.MealInfo;

public class CreateMealPopup extends HDialog {
	
	private static CreateMealPopupUiBinder uiBinder = GWT.create(CreateMealPopupUiBinder.class);

	interface CreateMealPopupUiBinder extends UiBinder<Widget, CreateMealPopup> {
	}
	
	@UiField TextBox nameBox;
	@UiField TextArea shortDescriptionBox, descriptionBox;
	private MealInfo mealInfo;
	
	public CreateMealPopup() {
		super();
		setWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	protected void updateInfo(IBasic iBasic) {
		MealInfo mealInfo = (MealInfo) iBasic;
		this.mealInfo = mealInfo;
		nameBox.setValue(mealInfo.getName());
		shortDescriptionBox.setValue(mealInfo.getShortDescription());
		descriptionBox.setValue(mealInfo.getDescription());
	}
	
	@Override
	public MealInfo getObject() {
		if(mealInfo == null) {
			mealInfo = new MealInfo();
		}
		mealInfo.setName(nameBox.getValue());
		mealInfo.setShortDescription(shortDescriptionBox.getValue());
		mealInfo.setDescription(descriptionBox.getValue());
		return mealInfo;
	}
}
