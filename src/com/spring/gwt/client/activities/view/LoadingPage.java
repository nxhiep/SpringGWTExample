package com.spring.gwt.client.activities.view;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.spring.gwt.client.ClientUtils;

public class LoadingPage {
	private static FlowPanel loadingPanel = new FlowPanel();
	
	public static void show() {
		if(loadingPanel.getParent() == null) {
			loadingPanel.setStyleName("loading-panel");
			loadingPanel.add(ClientUtils.getLoadingWidget());
			RootPanel.get().add(loadingPanel);
		}
		loadingPanel.setVisible(true);
	}
	
	public static void hide() {
		loadingPanel.setVisible(false);
	}
}
