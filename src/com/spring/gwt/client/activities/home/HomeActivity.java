package com.spring.gwt.client.activities.home;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.spring.gwt.client.ClientData;
import com.spring.gwt.client.activities.ClientFactory;
import com.spring.gwt.client.activities.basic.BasicActivity;
import com.spring.gwt.client.activities.view.LoadingPage;
import com.spring.gwt.client.activities.view.Toaster;
import com.spring.gwt.shared.ConfirmCallback;
import com.spring.gwt.shared.IBasic;
import com.spring.gwt.shared.model.MealInfo;

public class HomeActivity extends BasicActivity {
	
	private HomeView view;
	
	public HomeActivity(Place place, ClientFactory clientFactory) {
		super(place, clientFactory);
	}
	
	@Override
	protected void getParams(Place place) {
		super.getParams(place);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getHomeView();
		super.start(panel, eventBus, view);
	}
	
	@Override
	protected void bind() {
		super.bind();
		addHandlerRegistration(view.getAddMealButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				view.getCreateMealPopup().show("Add meal", null, new ConfirmCallback() {
					
					@Override
					public void onConfirm(boolean confirm) {
						if(confirm) {
							MealInfo mealInfo = view.getCreateMealPopup().getObject();
							updateMealInfo(mealInfo);
						}
					}
				});
			}
		}));
	}
	
	@Override
	protected void loadData() {
		super.loadData();
		loadMealInfo();
	}
	
	private void loadMealInfo() {
		LoadingPage.show();
		ClientData.DATA_SERVICE.getMeals(new AsyncCallback<List<MealInfo>>() {

			@Override
			public void onFailure(Throwable caught) {
				view.showMeals(null);
				LoadingPage.hide();
			}

			@Override
			public void onSuccess(List<MealInfo> result) {
				view.showMeals(result);
				LoadingPage.hide();
			}
		});
	}

	private void updateMealInfo(MealInfo mealInfo) {
		ClientData.DATA_SERVICE.update(mealInfo, new AsyncCallback<IBasic>() {
			
			@Override
			public void onSuccess(IBasic result) {
				Toaster.showSuccess("Updated success!");
				loadMealInfo();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Toaster.showSuccess("Updated failure!");
				loadMealInfo();
			}
		});
	}
}
