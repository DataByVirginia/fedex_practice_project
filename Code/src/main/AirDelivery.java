package main;

import javax.swing.*;

class AirDelivery extends Delivery {
	@Override
	public void calculateCost(Package pkg) {
		double cost = pkg.getWeight() * 10; // cost calculation
		String formattedCost = String.format("%.2f", cost); // Format to 2 decimal places
		JOptionPane.showMessageDialog(null,
				"Delivery Type: Air\n" + "Package ID: " + pkg.getId() + "\n" + "Weight: " + pkg.getWeight() + " kg\n"
						+ "Destination: " + pkg.getDestination() + "\n" + "Delivery Cost: $" + formattedCost,
				"FedEx Delivery Cost", JOptionPane.INFORMATION_MESSAGE);
	}
}
