package com.spring.gwt.client.activities.products;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconType;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.spring.gwt.client.ClientUtils;
import com.spring.gwt.client.SpringGWTBasic;
import com.spring.gwt.client.activities.basic.BasicViewImpl;
import com.spring.gwt.client.activities.products.widgets.CreateProductDialog;
import com.spring.gwt.client.activities.view.celltatble.CellTableView;
import com.spring.gwt.client.activities.view.celltatble.CellTableView.GetValue;
import com.spring.gwt.client.event.ActionEvent;
import com.spring.gwt.client.event.ActionEvent.Action;
import com.spring.gwt.client.view.HDropdownCell;
import com.spring.gwt.shared.model.IBasic;
import com.spring.gwt.shared.model.Product;

public class ProductsViewImpl extends BasicViewImpl implements ProductsView {

	private static ProductsViewImplUiBinder uiBinder = GWT.create(ProductsViewImplUiBinder.class);

	interface ProductsViewImplUiBinder extends UiBinder<Widget, ProductsViewImpl> {
	}
	
	@UiField FlowPanel contentPanel;
	@UiField Button buttonAddProduct;
	private CellTableView cellTableView;
	private CreateProductDialog createProductDialog;
	
	public ProductsViewImpl() {
		super();
		setView(uiBinder.createAndBindUi(this));
		setActiveTab(this.getBasicLayout().getButtonProducts());
		contentPanel.add(cellTableView = new CellTableView());
		buttonAddProduct.setType(ButtonType.SUCCESS);
		buttonAddProduct.setIcon(IconType.PLUS);
	}
	
	@Override
	public void view(List<Product> products) {
		List<IBasic> iBasics = new ArrayList<IBasic>(products);
		cellTableView.setData(iBasics);
		cellTableView.addColumn(cellTableView.getCellTable(), 40, new TextCell(), "STT", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				return (iBasics.indexOf(iBasic) + 1) + "";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		cellTableView.addColumn(cellTableView.getCellTable(), 150, new TextCell(), "Tên sản phẩm", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof Product) {
					return ((Product) iBasic).getName();
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		cellTableView.addColumn(cellTableView.getCellTable(), 150, new TextCell(), "Mô tả", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof Product) {
					return ((Product) iBasic).getDescription();
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
		/*
		cellTableView.addColumn(cellTableView.getCellTable(), 100, new TextCell(new SafeHtmlRenderer<String>() {
			
			@Override
			public void render(String html, SafeHtmlBuilder builder) {
				builder.appendHtmlConstant(html);
			}
			
			@Override
			public SafeHtml render(String html) {
				SafeHtmlBuilder builder = new SafeHtmlBuilder();
				builder.appendHtmlConstant(html);
				return builder.toSafeHtml();
			}
		}), "Ghi chú", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof Product) {
					return ((Product) iBasic).getNote();
				}
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
			}
	    });
	    */
		cellTableView.addColumn(cellTableView.getCellTable(), 80, new ClickableTextCell(), "Chi tiết", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				return "Chi tiết";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
				SpringGWTBasic.CLIENT_FACTORY.getEventBus().fireEvent(new ActionEvent(object, Action.VIEW));
			}
	    });
		cellTableView.addColumn(cellTableView.getCellTable(), 100, new ClickableTextCell(), "User", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				return "-";
			}
			
		}, new FieldUpdater<IBasic, String>() {
			@Override
			public void update(final int index, IBasic object, String value) {
				
			}
	    });
		cellTableView.addColumn(cellTableView.getCellTable(), 100, new ClickableTextCell(), "Cập nhật", new GetValue<String>() {

			@Override
			public String getValue(IBasic iBasic) {
				if (iBasic instanceof Product) {
					return ClientUtils.formatDate(((Product) iBasic).getLastUpdate(), null);
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
		cellTableView.addColumn(cellTableView.getCellTable(), 100, new HDropdownCell(items), "", new GetValue<Integer>() {

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
	public void refreshView() {
		super.refreshView();
	}
	
	@Override
	public CreateProductDialog getCreateProductDialog() {
		if(createProductDialog == null) {
			createProductDialog = new CreateProductDialog();
		}
		return createProductDialog;
	}
	
	@Override
	public Button getButtonAddProduct() {
		return buttonAddProduct;
	}
}
