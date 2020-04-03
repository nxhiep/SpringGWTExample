package com.spring.gwt.client.activities.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;

public class BasicSearchBox extends FlowPanel {
	
	private final int WIDTH = 200, HEIGHT = 40;
	private TextBox textBox = new TextBox();
	private Button searchButton = new Button("<i class=\"fad fa-search\"></i>");
	private FlowPanel dropdownPanel = new FlowPanel();
	
	public BasicSearchBox() {
		super();
		FlowPanel flexPanel = new FlowPanel();
		flexPanel.setStyleName("flex flex-ai-center flex-jc-space-between");
		flexPanel.add(textBox);
		flexPanel.add(searchButton);
		this.add(flexPanel);
		this.add(dropdownPanel);
		this.setStyleName("basic-search-box");
		dropdownPanel.setStyleName("search-box-dropdown-panel");
		textBox.setStyleName("search-box-text-box");
		searchButton.setStyleName("search-box-button");
		this.setSize(WIDTH + "px", HEIGHT + "px");
	}
	
	public void setPlaceHolder(String placeholder) {
		textBox.getElement().setAttribute("placeholder", placeholder);
	}
}
