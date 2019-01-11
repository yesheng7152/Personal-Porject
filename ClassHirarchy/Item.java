package spplementOne;

public class Item {
	//a generic entry in a cart
	//protected is use here, so variables may be accessed 
	//in subclasses
	protected String name;
	protected double cost;

	public Item (String productName, double price) {
		name =  productName;
		cost = price;
	}

	//getCost method return the cost of an item
	public double getCost () {
		return cost;
	}

	//costPerUnit return the cost of an item per itself(one quantity)
	public double costPerUnit() {
		return cost;
	}

	//toString method to yield nicely formatted output string
	public String toString() {
		return "Name: " + name + ", cost: " + cost;
	}

	//getName method return the name of the item in string
	public String getName() {
		return name;
	}

	//equals method returns a boolean if the item name is 
	//the same as str 
	public boolean equals (String str) {
		return name.equals(str);
	}

}

