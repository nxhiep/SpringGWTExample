package com.spring.gwt.client.activities.settings;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconType;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.ClientUtils;
import com.spring.gwt.client.SpringGWTBasic;
import com.spring.gwt.client.activities.basic.BasicViewImpl;
import com.spring.gwt.client.activities.settings.widgets.CreateActionDialog;
import com.spring.gwt.client.activities.settings.widgets.CreateActivityDialog;
import com.spring.gwt.client.activities.view.celltatble.CellTableView;
import com.spring.gwt.client.activities.view.celltatble.CellTableView.GetValue;
import com.spring.gwt.client.event.ActionEvent;
import com.spring.gwt.client.event.ActionEvent.Action;
import com.spring.gwt.client.view.HDropdownCell;
import com.spring.gwt.shared.model.ActionInfo;
import com.spring.gwt.shared.model.ActivityInfo;
import com.spring.gwt.shared.model.IBasic;

public class SettingsViewImpl extends BasicViewImpl implements SettingsView {

	private static SettingsViewImplUiBinder uiBinder = GWT.create(SettingsViewImplUiBinder.class);

	interface SettingsViewImplUiBinder extends UiBinder<Widget, SettingsViewImpl> {
	}
	
	@UiField FlowPanel activitiesPanel, actionsPanel;
	@UiField Button buttonAddActivity;
	@UiField LIElement liActivity, liAction;
	private CreateActivityDialog createActivityDialog;
	private CreateActionDialog createActionDialog;
	private CellTableView tableActivity;
	private CellTableView tableAction;
	
	public SettingsViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		setActiveTab(this.getBasicLayout().getButtonSettings());
		buttonAddActivity.setType(ButtonType.SUCCESS);
		buttonAddActivity.setIcon(IconType.PLUS);
		activitiesPanel.add(tableActivity = new CellTableView());
		actionsPanel.add(tableAction = new CellTableView());
	}
	
	@Override
	public void refreshView() {
		super.refreshView();
	}
	
	@Override
	public Button getButtonAddActivity() {
		return buttonAddActivity;
	}
	
	@Override
	public CreateActivityDialog getCreateActivityDialog() {
		if(createActivityDialog == null) {
			createActivityDialog = new CreateActivityDialog();
		}
		return createActivityDialog;
	}

	@Override
	public void showActions(List<ActionInfo> result) {
		List<IBasic> iBasics = new ArrayList<IBasic>(result);
		tableAction.refresh();
		tableAction.setData(iBasics);
		tableAction.addColumn(tableAction.getCellTable(), 40, new TextCell(), "STT", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				return (iBasics.indexOf(iBasic) + 1) + "";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableAction.addColumn(tableAction.getCellTable(), 150, new TextCell(), "Tên action", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActionInfo) {
					return ((ActionInfo) iBasic).getName();
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableAction.addColumn(tableAction.getCellTable(), 150, new TextCell(), "Mô tả", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActionInfo) {
					return ((ActionInfo) iBasic).getDescription();
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableAction.addColumn(tableAction.getCellTable(), 60, new TextCell(), "Code", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActionInfo) {
					return ((ActionInfo) iBasic).getCode();
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableAction.addColumn(tableAction.getCellTable(), 60, new TextCell(), "Số lần", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActionInfo) {
					return ((ActionInfo) iBasic).getTime() + "";
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableAction.addColumn(tableAction.getCellTable(), 60, new TextCell(), "Hệ số", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActionInfo) {
					return ((ActionInfo) iBasic).getCoefficient() + "";
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableAction.addColumn(tableAction.getCellTable(), 60, new TextCell(), "Activity", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableAction.addColumn(tableAction.getCellTable(), 60, new TextCell(), "Cập nhật", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActionInfo) {
					return ClientUtils.formatDate(((ActionInfo) iBasic).getLastUpdate(), null);
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		List<String> items = new ArrayList<String>();
		items.add("Sửa");
		items.add("Xem");
		items.add("Xoá");
		tableAction.addColumn(tableAction.getCellTable(), 100, new HDropdownCell(items), "", new GetValue<Integer>() {

			@Override
			public Integer getValue(IBasic iBasic) {
				return -1;
			}
			
		}, new FieldUpdater<IBasic, Integer>() {
			@Override
			public void update(final int index, IBasic object, Integer value) {
				if(value == 0) {
					SpringGWTBasic.CLIENT_FACTORY.getEventBus().fireEvent(new ActionEvent(object, Action.EDIT));
				} else if(value == 1) {
					SpringGWTBasic.CLIENT_FACTORY.getEventBus().fireEvent(new ActionEvent(object, Action.VIEW));
				} else if(value == 2) {
					SpringGWTBasic.CLIENT_FACTORY.getEventBus().fireEvent(new ActionEvent(object, Action.DELETE));
				}
			}
	    });
	}

	@Override
	public void showActivities(List<ActivityInfo> result) {
		List<IBasic> iBasics = new ArrayList<IBasic>(result);
		tableActivity.refresh();
		tableActivity.setData(iBasics);
		tableActivity.addColumn(tableActivity.getCellTable(), 40, new TextCell(), "STT", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				return (iBasics.indexOf(iBasic) + 1) + "";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableActivity.addColumn(tableActivity.getCellTable(), 150, new TextCell(), "Tên hoạt động", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActivityInfo) {
					return ((ActivityInfo) iBasic).getName();
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableActivity.addColumn(tableActivity.getCellTable(), 150, new TextCell(), "Mô tả", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActivityInfo) {
					return ((ActivityInfo) iBasic).getDescription();
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableActivity.addColumn(tableActivity.getCellTable(), 60, new TextCell(), "TM", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActivityInfo) {
					return ((ActivityInfo) iBasic).getTm() + "";
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableActivity.addColumn(tableActivity.getCellTable(), 60, new TextCell(), "TP", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActivityInfo) {
					return ((ActivityInfo) iBasic).getTp() + "";
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableActivity.addColumn(tableActivity.getCellTable(), 60, new TextCell(), "User", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		tableActivity.addColumn(tableActivity.getCellTable(), 60, new TextCell(), "Cập nhật", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof ActivityInfo) {
					return ClientUtils.formatDate(((ActivityInfo) iBasic).getLastUpdate(), null);
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		List<String> items = new ArrayList<String>();
		items.add("Sửa");
		items.add("Xem");
		items.add("Xoá");
		tableActivity.addColumn(tableActivity.getCellTable(), 100, new HDropdownCell(items), "", new GetValue<Integer>() {

			@Override
			public Integer getValue(IBasic iBasic) {
				return -1;
			}
			
		}, new FieldUpdater<IBasic, Integer>() {
			@Override
			public void update(final int index, IBasic object, Integer value) {
				if(value == 0) {
					SpringGWTBasic.CLIENT_FACTORY.getEventBus().fireEvent(new ActionEvent(object, Action.EDIT));
				} else if(value == 1) {
					SpringGWTBasic.CLIENT_FACTORY.getEventBus().fireEvent(new ActionEvent(object, Action.VIEW));
				} else if(value == 2) {
					SpringGWTBasic.CLIENT_FACTORY.getEventBus().fireEvent(new ActionEvent(object, Action.DELETE));
				}
			}
	    });
	}
	
	@Override
	public CreateActionDialog getCreateActionDialog() {
		if(createActionDialog == null) {
			createActionDialog = new CreateActionDialog();
		}
		return createActionDialog;
	}
	
	@Override
	public boolean isActivityTab() {
		return liActivity.hasClassName("active");
	}
	
	@Override
	public boolean isActionTab() {
		return liAction.hasClassName("active");
	}
}
