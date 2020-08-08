package com.hust.textile.client.activities.products.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.textile.client.view.ImageItemPanel;
import com.hust.textile.client.view.UploaderPanel;
import com.hust.textile.shared.model.ProductInfo;

public class TechnologicalProcessPanel extends Composite {
	
	private static TechnologicalProcessPanelUiBinder uiBinder = GWT.create(TechnologicalProcessPanelUiBinder.class);

	interface TechnologicalProcessPanelUiBinder extends UiBinder<Widget, TechnologicalProcessPanel> {
	}
	
	@UiField UploaderPanel uploaderDiagramBlock, uploaderDiagramAsembly, uploaderTechologicalProcess, uploaderTechologicalTable;
	@UiField FlowPanel imagesDiagramBlockPanel, imagesDiagramAsemblyPanel, imagesTechologicalProcessPanel, imagesTechologicalTablePanel;
	
	private ProductInfo productInfo;
	public TechnologicalProcessPanel(ProductInfo productInfo) {
		this.productInfo = productInfo;
		initWidget(uiBinder.createAndBindUi(this));
		initUploaderPanel(uploaderDiagramBlock, uploaderDiagramAsembly);
		initUploaderPanel(uploaderDiagramAsembly, imagesDiagramAsemblyPanel);
		initUploaderPanel(uploaderTechologicalProcess, imagesTechologicalProcessPanel);
		initUploaderPanel(uploaderTechologicalTable, imagesTechologicalTablePanel);
	}
	
	private void initUploaderPanel(UploaderPanel uploaderPanel, FlowPanel imagesPanel) {
		imagesPanel.clear();
		uploaderPanel.setCompleteHandler(new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String url) {
				imagesPanel.add(new ImageItemPanel(url));
			}
			
			@Override
			public void onFailure(Throwable arg0) {
			}
		});
	}
	
	public ProductInfo getProductInfo() {
		return productInfo;
	}
}
