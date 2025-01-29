
package main;

import javax.swing.*;

class DroneDelivery extends Delivery {
	@Override
	public void calculateCost(Package pkg) {
		double cost = pkg.getWeight() * 418151.45; // Alphabet to numbers for drone is 4 18 15 14 5 and it would be exspensive
		String formattedCost = String.format("%.2f", cost); // Format to 2 decimal places
		JOptionPane.showMessageDialog(null,
				"Delivery Type: Drone\n" + "Package ID: " + pkg.getId() + "\n" + "Weight: " + pkg.getWeight() + " kg\n"
						+ "Destination: " + pkg.getDestination() + "\n" + "Delivery Cost: $" + formattedCost,
				"FedEx Delivery Cost", JOptionPane.INFORMATION_MESSAGE);
	}
}

/*
 - Inherits from 'Delivery' then overrides 'calculateCost()' with drone-specific pricing 
 - Uses encapsulation by pulling package details via getters.
 - Shows polymorphism in cost logic.
*/
