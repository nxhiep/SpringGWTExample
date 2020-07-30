package com.hust.textile.client.activities.settings.widgets;

import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.hust.textile.client.view.MyDialog;
import com.hust.textile.client.view.Toaster;
import com.hust.textile.shared.Config;
import com.hust.textile.shared.model.ActionInfo;

public class CreateActionDialog extends MyDialog {

	private static CreateActionDialogUiBinder uiBinder = GWT.create(CreateActionDialogUiBinder.class);

	interface CreateActionDialogUiBinder extends UiBinder<Widget, CreateActionDialog> {
	}
	
	@UiField TextBox nameBox, codeBox, timeBox, coefficientBox;
	@UiField TextArea descriptionBox;
	private ActionInfo actionInfo;

	public CreateActionDialog() {
		this.getMainPanel().add(uiBinder.createAndBindUi(this));
	}
	
	public void show(ActionInfo actionInfo, String title, AsyncCallback<Void> callBack) {
		this.callBack = callBack;
		update(actionInfo);
		super.show(title, null, "Lưu", "huỷ", callBack);
	}

	private void update(ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
		nameBox.setValue(actionInfo != null ? actionInfo.getName() : "");
		codeBox.setValue(actionInfo != null ? actionInfo.getCode() : "");
		timeBox.setValue("" + (actionInfo != null ? actionInfo.getTime() : ""));
		descriptionBox.setValue(actionInfo != null ? actionInfo.getDescription() : "");
		coefficientBox.setValue("" + (actionInfo != null ? actionInfo.getCoefficient() : ""));
	}
	
	public ActionInfo getAction() {
		if(actionInfo == null) {
			actionInfo = new ActionInfo();
		}
		actionInfo.setName(nameBox.getValue());
		actionInfo.setCode(codeBox.getValue());
		actionInfo.setTime(Double.parseDouble(timeBox.getValue()));
		actionInfo.setCoefficient(Double.parseDouble(coefficientBox.getValue()));
		actionInfo.setDescription(descriptionBox.getValue());
		return actionInfo;
	}
	
	public boolean isValidated() {
		if(nameBox.getValue().isEmpty()) {
			Toaster.showError("Tên trống!");
			return false;
		}
		double time = Config.LONG_NULL;
		try {
			time = Double.parseDouble(timeBox.getValue());
		} catch(Exception e) {}
		if(time <= 0) {
			Toaster.showError("Số lần không đúng!");
			return false;
		}
		double coefficient = Config.LONG_NULL;
		try {
			coefficient = Double.parseDouble(coefficientBox.getValue());
		} catch(Exception e) {}
		if(coefficient <= 0) {
			Toaster.showError("Hệ số không đúng!");
			return false;
		}
		return true;
	}
}
