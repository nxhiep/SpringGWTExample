package com.spring.gwt.client.activities.settings.widgets;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.view.HMultipleSelect;
import com.spring.gwt.client.view.MyDialog;
import com.spring.gwt.client.view.Toaster;
import com.spring.gwt.shared.Config;
import com.spring.gwt.shared.model.ActionInfo;
import com.spring.gwt.shared.model.ActivityInfo;

public class CreateActivityDialog extends MyDialog {

	private static CreateActivityDialogUiBinder uiBinder = GWT.create(CreateActivityDialogUiBinder.class);

	interface CreateActivityDialogUiBinder extends UiBinder<Widget, CreateActivityDialog> {
	}
	
	@UiField TextBox nameBox, tpBox, tmBox;
	@UiField HMultipleSelect selectActions;
	@UiField TextArea descriptionBox;
	private ActivityInfo activity;

	public CreateActivityDialog() {
		this.getMainPanel().add(uiBinder.createAndBindUi(this));
	}
	
	public void updatedActions(List<ActionInfo> actions) {
		selectActions.clear();
		for (ActionInfo action : actions) {
			selectActions.addItem("", action.getName(), action.getId().toString(), false, action);
		}
		selectActions.refreshSelect();
	}

	public void show(ActivityInfo activity, String title, AsyncCallback<Void> callBack) {
		this.callBack = callBack;
		update(activity);
		super.show(title, null, "Lưu", "huỷ", callBack);
	}

	private void update(ActivityInfo activity) {
		this.activity = activity;
		nameBox.setValue(activity != null ? activity.getName() : "");
		tpBox.setValue("" + (activity != null ? activity.getTp() : ""));
		tmBox.setValue("" + (activity != null ? activity.getTm() : ""));
		descriptionBox.setValue(activity != null ? activity.getDescription() : "");
		selectActions.setSelectedIds(activity != null ? activity.getActionIds() : new ArrayList<Long>());
	}
	
	public ActivityInfo getActivity() {
		if(activity == null) {
			activity = new ActivityInfo();
		}
		activity.setName(nameBox.getValue());
		activity.setTm(Double.parseDouble(tmBox.getValue()));
		activity.setTp(Double.parseDouble(tpBox.getValue()));
		activity.setActionIds(selectActions.getSelectedLongIds());
		activity.setDescription(descriptionBox.getValue());
		return activity;
	}
	
	public boolean isValidated() {
		if(nameBox.getValue().isEmpty()) {
			Toaster.showError("Tên trống!");
			return false;
		}
		double tm = Config.LONG_NULL;
		try {
			tm = Double.parseDouble(tmBox.getValue());
		} catch(Exception e) {}
		if(tm <= 0) {
			Toaster.showError("TM không đúng!");
			return false;
		}
		double tp = Config.LONG_NULL;
		try {
			tp = Double.parseDouble(tpBox.getValue());
		} catch(Exception e) {}
		if(tp <= 0) {
			Toaster.showError("TP không đúng!");
			return false;
		}
		if(selectActions.getSelectedLongIds().isEmpty()) {
			Toaster.showError("Chưa chọn action trống!");
			return false;
		}
		return true;
	}
}
