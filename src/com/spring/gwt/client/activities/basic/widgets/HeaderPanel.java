package com.spring.gwt.client.activities.basic.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class HeaderPanel extends Composite {

	private static HeaderPanelUiBinder uiBinder = GWT.create(HeaderPanelUiBinder.class);

	interface HeaderPanelUiBinder extends UiBinder<Widget, HeaderPanel> {
	}

	@UiField HTML titlePanel;
	
	public HeaderPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setTitlePage(String title) {
		titlePanel.setHTML(title);
	}
}
