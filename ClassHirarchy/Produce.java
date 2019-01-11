package spplementOne;

import spplementOne.Item;

public class Produce extends Item {
	//Produce have two special fields
	private double pounds;
	private String category;

	public Produce (String productName, double price, double weight, String type) {
		super(productName, price);
		pounds=weight;
		category=type;
	}
	
	//costPerUnit method calculated the cost per pound 
	public double costPerUnit() {
		return (cost / pounds);
	}
	//toString method to yield nicely formatted output string
	public String toString() {
		return super.toString() + 
				", Category: " + category + ", weight: " + pounds;
	}

} 
