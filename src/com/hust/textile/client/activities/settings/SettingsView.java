package com.hust.textile.client.activities.settings;

import java.util.List;

import org.gwtbootstrap3.client.ui.Button;

import com.hust.textile.client.activities.basic.BasicView;
import com.hust.textile.client.activities.settings.widgets.CreateActionDialog;
import com.hust.textile.client.activities.settings.widgets.CreateActivityDialog;
import com.hust.textile.shared.model.ActionInfo;
import com.hust.textile.shared.model.ActivityInfo;

public interface SettingsView extends BasicView {

	Button getButtonAddActivity();

	CreateActivityDialog getCreateActivityDialog();

	void showActions(List<ActionInfo> result);

	void showActivities(List<ActivityInfo> result);

	CreateActionDialog getCreateActionDialog();

	boolean isActivityTab();

	boolean isActionTab();
}
