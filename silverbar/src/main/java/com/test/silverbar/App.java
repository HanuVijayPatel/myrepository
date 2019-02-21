package com.test.silverbar;

import com.test.silverbar.model.SilverBarOrder;
import com.test.silverbar.model.SilverBarOrder.OrderType;
import com.test.silverbar.services.IOrderBoard;
import com.test.silverbar.services.OrderBoard;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( " - : Silver Bars Marketplace  : -" );
        IOrderBoard myBoard = new OrderBoard();
        
        // generate the order book...
        myBoard.registerOrder(new SilverBarOrder("1", 110.20, 100, OrderType.SELL));
        myBoard.registerOrder(new SilverBarOrder("2", 220.10, 100, OrderType.SELL));
        myBoard.registerOrder(new SilverBarOrder("3", 330, 100, OrderType.SELL));
        myBoard.registerOrder(new SilverBarOrder("4", 410, 100, OrderType.SELL));
        myBoard.registerOrder(new SilverBarOrder("5", 610, 100, OrderType.SELL));
        myBoard.registerOrder(new SilverBarOrder("6", 330, 100, OrderType.SELL));
        myBoard.registerOrder(new SilverBarOrder("1", 510, 100, OrderType.BUY));
        myBoard.registerOrder(new SilverBarOrder("2", 610, 100, OrderType.BUY));
        myBoard.registerOrder(new SilverBarOrder("3", 410, 100, OrderType.BUY));
        myBoard.registerOrder(new SilverBarOrder("4", 310, 100, OrderType.BUY));
        myBoard.registerOrder(new SilverBarOrder("5", 310, 100, OrderType.BUY));
        myBoard.registerOrder(new SilverBarOrder("6", 510, 100, OrderType.BUY));
        
        myBoard.showOderSummary();
        // deletes
        myBoard.cancelOrder(new SilverBarOrder("6", 510, 100, OrderType.BUY));
        myBoard.cancelOrder(new SilverBarOrder("1", 110.20, 100, OrderType.SELL));
        myBoard.showOderSummary();
        // add
        myBoard.registerOrder(new SilverBarOrder("9", 410, 300, OrderType.BUY));
        myBoard.registerOrder(new SilverBarOrder("7", 610.20, 100, OrderType.SELL));
        myBoard.showOderSummary();
    }
}
