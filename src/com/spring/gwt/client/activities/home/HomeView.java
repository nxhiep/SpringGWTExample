package com.spring.gwt.client.activities.home;

import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.spring.gwt.client.activities.basic.BasicView;
import com.spring.gwt.client.activities.home.widgets.CreateMealPopup;
import com.spring.gwt.shared.model.MealInfo;

public interface HomeView extends BasicView {

	void showMeals(List<MealInfo> result);

	Button getAddMealButton();

	CreateMealPopup getCreateMealPopup();

}
