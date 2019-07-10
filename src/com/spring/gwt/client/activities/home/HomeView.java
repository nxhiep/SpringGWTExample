package com.spring.gwt.client.activities.home;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.spring.gwt.client.activities.basic.BasicView;

public interface HomeView extends BasicView {

	HasClickHandlers getButtonCategory();

	HasClickHandlers getButtonCreateTestModel();

	void updateStatusCreateTestModel(String status);
}
