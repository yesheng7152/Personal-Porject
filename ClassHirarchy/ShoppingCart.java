package spplementOne;

import spplementOne.Item;
import spplementOne.Package;
import spplementOne.Beverage;
import spplementOne.Produce;

public class ShoppingCart {
	private int maxSize;
	private int currentSize;
	private Item [] Cart;

	ShoppingCart (){
		maxSize=4; //initial maximum
		currentSize=0;
		Cart = new Item [maxSize];
	}

	//addItem method add an item to the array of items
	public void addItem (Item Food ) {
		//check if room in array, and double array in size 
		//if needed
		if (currentSize == maxSize) {
			maxSize = 2 * maxSize;
			Item [] temp = new Item [maxSize];
			for (int i=0; i < currentSize; i++)
				temp[i] = Cart[i];
			//update Cart to the new, larger array 
			Cart = temp;
		}
		//add item to array
		int i = currentSize;
		while (i > 0) {
			Cart[i]=Cart[i-1];
			i--;
		}
		Cart[i]=Food;	
		currentSize++;
	}
	
	//printCart method print the list of item and it's fields 
	// that's in the array
	public void printCart () {
		System.out.println("Items in the cart");
		for (int j=0; j<currentSize; j++)
			System.out.println(Cart[j]);
		System.out.println ("End of the list");
	}

	//totalCost method print the total cost of all items in the list
	public double totalCost () {
		double total=0;
		for (int i=0; i<currentSize; i++)
			total += Cart[i].cost;
		return total;
	}

	//numberInCart method print the number of times groceryName
	//appeared in the array, as a name for the item. 
	public int numberInCart (String groceryName) {
		int count=0;
		for (int j=0; j< currentSize; j++) {
			if (Cart[j].getName().equals(groceryName))
				count +=1;
		}
		return count;
	}

	
	public static void main (String [] argv) {
		//test of various methods
		//constructors 
		ShoppingCart shopcart = new ShoppingCart();
		Package cheese = new Package ("Cheese", 1.50, 5, 2, 2, 1.3);
		Produce spinach = new Produce ("Spanich", 3.99, 5, "vegetable");
		Beverage coke = new Beverage ("Coca cola", 4.99, 40, 1.5);
		Item chicken = new Produce ("Chicken", 5.99, 5, "meat");
		Package bread = new Package ("Bread", 3.50, 15, 4, 4, 5);
		Package honeybread = new Package ("Bread", 4.50, 15, 4, 3, 5);
		
		
		//add groceries into the cart
		shopcart.addItem(cheese);
		shopcart.addItem(spinach);
		shopcart.addItem(coke);
		shopcart.addItem(chicken);
		shopcart.addItem(bread);
		shopcart.addItem(honeybread);
		
		//checking for method in Beverage
		//the total cost of coke including container deposit
		System.out.println("the cost of coke is: " +
				coke.getCost());
		//the cost per unit for coke
		System.out.println("the cost of coke per unit is: " +
				coke.costPerUnit());


		//checking for method in Produce 
		//the cost per unit for chicken
		System.out.println("the cost of chicken per pound is: " +
				chicken.costPerUnit());

		
		//print the groceries in the list
		shopcart.printCart();
		
		
		//checking for total cost of the list
		System.out.println("The total cost of the shopping cart is: " 
				+ shopcart.totalCost());


		//checking for number of items in a cart
		System.out.println("Number of 'Bread' in the cart: " 
				+ shopcart.numberInCart("Bread"));

	}

}

	

