package spplementOne;

import spplementOne.Item;

public class Beverage extends Item {
	//Beverage have two special fields
	private int fluidOunces;
	private double containerDeposit;

	public Beverage (String productName, double price, int ounces, double deposit) {
		super(productName, price);
		fluidOunces = ounces;
		containerDeposit= deposit;
	}

	// getCost method calculated the total cost of a beverage by
	// adding the cost of the item and it's container deposit
	public double getCost () {
		return (cost + containerDeposit);
	}	

	//costPerUnit method calculated the cost per fluid ounces
	public double costPerUnit() {
		return (cost / fluidOunces);
	}
	
	//toString method to yield nicely formatted output string
	public String toString() {
		return super.toString() + 
				", Fluid ounces: " + fluidOunces + 
				", container deposit: " + containerDeposit;
	}
}
