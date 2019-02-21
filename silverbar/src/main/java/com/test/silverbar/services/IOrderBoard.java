package com.test.silverbar.services;

import java.util.List;

import com.test.silverbar.model.DisplayOrder;
import com.test.silverbar.model.SilverBarOrder;

public interface IOrderBoard {

	List<DisplayOrder> getBuyOrders();

	List<DisplayOrder> getSellOrders();

	boolean registerOrder(SilverBarOrder sbOrder);

	boolean cancelOrder(SilverBarOrder sbOrder);

	void showOderSummary();
}