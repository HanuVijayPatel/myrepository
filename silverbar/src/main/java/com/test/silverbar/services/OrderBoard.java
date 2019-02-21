package com.test.silverbar.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.test.silverbar.model.DisplayOrder;
import com.test.silverbar.model.SilverBarOrder;
import com.test.silverbar.model.SilverBarOrder.OrderType;

/**
 * 
 * Service class
 *
 */
public class OrderBoard implements IOrderBoard {


	private List<SilverBarOrder> orderBook = new ArrayList<SilverBarOrder>();

	private List<DisplayOrder> buyOrders =  new ArrayList<DisplayOrder>();
	private List<DisplayOrder> sellOrders = new ArrayList<DisplayOrder>();


	public List<DisplayOrder> getBuyOrders() {
		return buyOrders;
	}

	public List<DisplayOrder> getSellOrders() {
		return sellOrders;
	}

	public boolean isValidOrder(SilverBarOrder sbOrder) {
		if(sbOrder != null) {
			if( sbOrder.getUserID() != null &&
					sbOrder.getType() != null && 
					sbOrder.getPrice() > 0 &&
					sbOrder.getQuantity() > 0 ) {
					return true;
			}
		}		
		return false;
		
	}
	public boolean registerOrder(SilverBarOrder sbOrder) {

		if(isValidOrder(sbOrder)) {
			if(sbOrder != null) {

				orderBook.add(sbOrder);

				if(sbOrder.getType() == OrderType.BUY) {
					// update Buy display order
					DisplayOrder dOrder =  new DisplayOrder(sbOrder.getQuantity(), sbOrder.getPrice());
					if(buyOrders.contains(dOrder)) {
						int idx = buyOrders.indexOf(dOrder);
						buyOrders.get(idx).addQuantity(sbOrder.getQuantity());

					} else {
						// new price.. so add in display order
						buyOrders.add(dOrder);
					}

					// sort the display order..
					Collections.sort(buyOrders);

				} else {
					// update Sell display order 

					DisplayOrder dOrder =  new DisplayOrder(sbOrder.getQuantity(), sbOrder.getPrice());
					if(sellOrders.contains(dOrder)) {
						int idx = sellOrders.indexOf(dOrder);
						sellOrders.get(idx).addQuantity(sbOrder.getQuantity());

					} else {
						// new price.. so add in display order
						sellOrders.add(dOrder);
					}

					// sort the display order..
					Collections.sort(sellOrders);
					Collections.reverse(sellOrders);

				}

				return true;
			} 
		}
		return false;
	}

	public boolean cancelOrder(SilverBarOrder sbOrder) {

		//remove order from book.
		boolean result = orderBook.remove(sbOrder);

		if(result) {

			if(sbOrder.getType() == OrderType.BUY) {

				// update Buy display order

				DisplayOrder dOrder =  new DisplayOrder(sbOrder.getQuantity(), sbOrder.getPrice());
				if(buyOrders.contains(dOrder)) {
					int idx = buyOrders.indexOf(dOrder);
					buyOrders.get(idx).reduceQuantity(sbOrder.getQuantity());
				} 
				// sort the display order..
				Collections.sort(buyOrders);

			} else {

				// update Sell display order

				DisplayOrder dOrder =  new DisplayOrder(sbOrder.getQuantity(), sbOrder.getPrice());
				if(sellOrders.contains(dOrder)) {
					int idx = sellOrders.indexOf(dOrder);
					sellOrders.get(idx).reduceQuantity(sbOrder.getQuantity());
				} 

				// sort the display order..
				Collections.sort(sellOrders);
				Collections.reverse(sellOrders);
			}
		}

		return result;
	}

	/**
	 * Utility method...
	 */
	public void showOderSummary() {

		System.out.println("\n------ Order Book Summary ------");
		System.out.println("\n.:: SELL ORDERS ::.");
		for(DisplayOrder so : this.getSellOrders()) {
			System.out.println(so);
		}

		System.out.println("\n.:: BUY ORDERS ::.");
		for(DisplayOrder so : this.getBuyOrders()) {
			System.out.println(so);
		}

	}


}
