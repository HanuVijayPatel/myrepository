package com.test.silverbar.model;

/**
 * 
 *  Model Class for UI
 *
 */
public class DisplayOrder implements Comparable<DisplayOrder>  {

    private double quantity;
    private double price;

    public DisplayOrder(double q, double p) {
        quantity = q;
        price = p;
    }
    
    public void addQuantity(double q) {
    	this.quantity = this.quantity + q;
    }
	
	public int compareTo(DisplayOrder o) {
    	
    	if (this.price == o.price) {
    		return 0;
    	} else if (this.price > o.price) {
    		return -1;
    	} else {
    		return 1;
    	}
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DisplayOrder))
			return false;
		DisplayOrder other = (DisplayOrder) obj;
		if (price != other.price)
			return false;
		return true;
	}

    public double getPrice() {
		return price;
	}

	public double getQuantity() {
		return quantity;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public void reduceQuantity(double q) {
    	this.quantity = this.quantity - q;
    }

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String toString() {
        return "[ " + this.quantity + "kg  for  £" + this.price +"]";
    }

}
