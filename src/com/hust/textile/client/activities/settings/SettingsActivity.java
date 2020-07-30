package com.hust.textile.client.activities.settings;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.hust.textile.client.ClientData;
import com.hust.textile.client.activities.ClientFactory;
import com.hust.textile.client.activities.basic.BasicActivity;
import com.hust.textile.client.activities.settings.widgets.CreateActionDialog;
import com.hust.textile.client.activities.settings.widgets.CreateActivityDialog;
import com.hust.textile.client.event.ActionEvent;
import com.hust.textile.client.event.ActionEventHandler;
import com.hust.textile.client.event.ActionEvent.Action;
import com.hust.textile.client.view.MyDialog;
import com.hust.textile.shared.model.ActionInfo;
import com.hust.textile.shared.model.ActivityInfo;
import com.hust.textile.shared.model.IBasic;

public class SettingsActivity extends BasicActivity {
	
	private SettingsView view;
	
	public SettingsActivity(Place place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}
	
	@Override
	protected void getParams(Place place) {
		super.getParams(place);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getSettingsView();
		super.start(panel, eventBus, view);
	}
	
	@Override
	protected void bind() {
		super.bind();
		addHandlerRegistration(view.getButtonAddActivity().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(view.isActionTab()) {
					showUpdateActionDialog(null);
				} else if(view.isActivityTab()) {
					showUpdateActivityDialog(null);
				}
			}
		}));
		addHandlerRegistration(eventBus.addHandler(ActionEvent.TYPE, new ActionEventHandler() {
			
			@Override
			public void onEvent(ActionEvent event) {
				IBasic iBasic = event.getIBasic();
				if(Action.EDIT.equals(event.getAction())) {
					if(iBasic instanceof ActionInfo) {
						showUpdateActionDialog((ActionInfo) iBasic);
					} else if(iBasic instanceof ActivityInfo) {
						showUpdateActivityDialog((ActivityInfo) iBasic);
					}
				} else if(Action.VIEW.equals(event.getAction())) {
					if(iBasic instanceof ActionInfo) {
						//TODO:
					} else if(iBasic instanceof ActivityInfo) {
						//TODO:
					}
				} else if(Action.DELETE.equals(event.getAction())) {
					deleteObject(iBasic, new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
						}

						@Override
						public void onSuccess(Void result) {
							if(iBasic instanceof ActionInfo) {
								loadActions();
							} else if(iBasic instanceof ActivityInfo) {
								loadActivities();
							}
						}
					});
				}
			}
		}));
	}
	
	protected void deleteObject(IBasic iBasic, AsyncCallback<Void> callback) {
		MyDialog myDialog = new MyDialog();
		myDialog.show("Bạn muốn xoá sản phẩm", null, "Đồng ý", "Huỷ", new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				ClientData.delete(iBasic, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						myDialog.hide();
						callback.onSuccess(null);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						myDialog.hide();
						callback.onFailure(caught);
					}
				});
			}
			
			@Override
			public void onFailure(Throwable caught) {
				myDialog.hide();
				callback.onFailure(caught);
			}
		});
	}
	
	protected void showUpdateActionDialog(ActionInfo actionInfo) {
		CreateActionDialog createActionDialog = view.getCreateActionDialog();
		createActionDialog.show(actionInfo, "Tạo Activity", new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				if(createActionDialog.isValidated()) {
					updateObject(createActionDialog.getAction(), new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							createActionDialog.hide();
						}

						@Override
						public void onSuccess(Void result) {
							createActionDialog.hide();
							loadActions();
						}
					});
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				createActionDialog.hide();
			}
		});
	}
	
	protected void showUpdateActivityDialog(ActivityInfo activityInfo) {
		CreateActivityDialog createActivityDialog = view.getCreateActivityDialog();
		createActivityDialog.show(activityInfo, "Tạo Activity", new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				if(createActivityDialog.isValidated()) {
					updateObject(createActivityDialog.getActivity(), new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							createActivityDialog.hide();
						}

						@Override
						public void onSuccess(Void result) {
							createActivityDialog.hide();
							loadActivities();
						}
					});
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				createActivityDialog.hide();
			}
		});
	}
	
	protected void updateObject(IBasic iBasic, AsyncCallback<Void> callback) {
		ClientData.save(iBasic, new AsyncCallback<IBasic>() {
			
			@Override
			public void onSuccess(IBasic result) {
				callback.onSuccess(null);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
		});
	}

	@Override
	protected void loadData() {
		super.loadData();
		loadActions();
		loadActivities();
	}

	private void loadActivities() {
		ClientData.DATA_SERVICE.getActivities(new AsyncCallback<List<ActivityInfo>>() {
			
			@Override
			public void onSuccess(List<ActivityInfo> result) {
				view.showActivities(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}

	private void loadActions() {
		ClientData.DATA_SERVICE.getActions(new AsyncCallback<List<ActionInfo>>() {
			
			@Override
			public void onSuccess(List<ActionInfo> result) {
				view.showActions(result);
				view.getCreateActivityDialog().updatedActions(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
}
