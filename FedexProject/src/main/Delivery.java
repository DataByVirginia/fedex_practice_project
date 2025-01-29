package main;

// Abstract class: You can’t create an instance of Delivery directly
abstract class Delivery {
	// Abstract method: No implementation here. Child classes override it
	public abstract void calculateCost(Package pkg);
}
