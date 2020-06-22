package com.spring.gwt.client.activities.settings;

import java.util.List;

import org.gwtbootstrap3.client.ui.Button;

import com.spring.gwt.client.activities.basic.BasicView;
import com.spring.gwt.client.activities.settings.widgets.CreateActionDialog;
import com.spring.gwt.client.activities.settings.widgets.CreateActivityDialog;
import com.spring.gwt.shared.model.ActionInfo;
import com.spring.gwt.shared.model.ActivityInfo;

public interface SettingsView extends BasicView {

	Button getButtonAddActivity();

	CreateActivityDialog getCreateActivityDialog();

	void showActions(List<ActionInfo> result);

	void showActivities(List<ActivityInfo> result);

	CreateActionDialog getCreateActionDialog();

	boolean isActivityTab();

	boolean isActionTab();
}
