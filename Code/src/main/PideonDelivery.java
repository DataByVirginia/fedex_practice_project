package main;

import javax.swing.*;

class PigeonDelivery extends Delivery { // With vinyl coming back, 'courier' pigeon might come back into style too
	@Override
	public void calculateCost(Package pkg) {
		double cost = pkg.getWeight() * 1123.58; // Based on the 'Pigeonacci' sequence
		String formattedCost = String.format("%.2f", cost); // Format to 2 decimal places
		JOptionPane.showMessageDialog(null,
				"Delivery Type: Pigeon\n" + "Package ID: " + pkg.getId() + "\n" + "Weight: " + pkg.getWeight() + " kg\n"
						+ "Destination: " + pkg.getDestination() + "\n" + "Delivery Cost: $" + formattedCost,
				"FedEx Delivery Cost", JOptionPane.INFORMATION_MESSAGE);
	}
}

/*
 - Inherits from 'Delivery' then overrides 'calculateCost()' with pigeon-specific pricing 
 	(yes, it's expensive, but so is vinyl.)
 - Uses encapsulation by pulling package details via getters.
 - Shows polymorphism in cost logic.

 Keeps things modular, reusable, and ready for when carrier pigeons make a comeback.
*/
