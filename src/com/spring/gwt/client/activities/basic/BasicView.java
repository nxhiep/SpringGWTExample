package com.spring.gwt.client.activities.basic;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.IsWidget;
import com.spring.gwt.client.activities.basic.BasicViewImpl.BasicLayout;

public interface BasicView extends IsWidget {

	void refreshView();

	BasicLayout getBasicLayout();

	void setEventBus(EventBus eventBus);

}