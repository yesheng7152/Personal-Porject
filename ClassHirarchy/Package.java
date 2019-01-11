package spplementOne;

import spplementOne.Item;

public class Package extends Item {
	//Package have four special fields
	private double length;
	private double width;
	private double height;
	private int ounces;

	public Package (String productName, double price, int weight, double len, double wid, double tall) {
		super(productName, price);
		length = len;
		width = wid;
		height = tall;
		ounces = weight;
	}

	//toString method to yield nicely formatted output string
	public String toString() {
		return super.toString()
				+ ", Length: " + length + ", width: " + width 
				+ ", height: " + height + ", weight: " + ounces
				+ ", Size: " + (length * width * height);
	}


}
