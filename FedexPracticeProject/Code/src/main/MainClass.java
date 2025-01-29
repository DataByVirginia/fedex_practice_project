package main;

import javax.swing.*;
import java.awt.*;

public class MainClass {
	public static void main(String[] args) {
		// Apply FedEx theme
		UIManager.put("OptionPane.background", new Color(102, 0, 153)); // FedEx purple
		UIManager.put("Panel.background", new Color(102, 0, 153)); // Same background
		UIManager.put("OptionPane.messageForeground", Color.WHITE); // White text
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 16)); // Bold font

		// Load FedEx logo
		ImageIcon originalIcon = new ImageIcon("fedex_logo.png");
		Image scaledImage = originalIcon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
		ImageIcon fedexIcon = new ImageIcon(scaledImage);

		// Step 1: Create a package
		String packageId = JOptionPane.showInputDialog(null, "Enter Package ID:", "FedEx Package Input",
				JOptionPane.QUESTION_MESSAGE, fedexIcon, // Custom icon
				null, null).toString();
		String packageDestination = JOptionPane.showInputDialog(null, "Enter Package Destination:",
				"FedEx Package Input", JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();

		Package pkg = new Package(packageId, 0, packageDestination);

		while (true) {
			try {
				String weightInput = JOptionPane.showInputDialog(null, "Enter Package Weight (kg):",
						"FedEx Package Input", JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();
				pkg.validateAndSetWeight(weightInput);
				break;
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE,
						fedexIcon);
			}
		}

		JOptionPane.showMessageDialog(null,
				"Package Created:\n" + "ID: " + pkg.getId() + "\n" + "Weight: " + pkg.getWeight() + " kg\n"
						+ "Destination: " + pkg.getDestination(),
				"FedEx Package Details", JOptionPane.INFORMATION_MESSAGE, fedexIcon);

		// Step 2: Choose a delivery type
		Delivery delivery = null; // Declare the delivery object

		while (true) {
			try {
				String choiceInput = JOptionPane.showInputDialog(null,
						"Choose a Delivery Type:\n1. Ground Delivery\n2. Air Delivery\n3. Drone Delivery\n4. Pigeon Delivery",
						"FedEx Delivery Type", JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();

				// Handle cancel or close
				if (choiceInput == null) {
					JOptionPane.showMessageDialog(null, "No delivery type selected. Exiting.");
					System.exit(0);
				}

				int choice = Integer.parseInt(choiceInput); // Parse input to integer
				if (choice == 1) {
					delivery = new GroundDelivery();
					break; // Valid choice
				} else if (choice == 2) {
					delivery = new AirDelivery();
					break; // Valid choice
				} else if (choice == 3) {
					delivery = new DroneDelivery();
					break; // Valid choice
				} else if (choice == 4) {
					delivery = new PigeonDelivery();
					break; // Valid choice
				} else {
					JOptionPane.showMessageDialog(null,
							"Invalid choice. Please select 1 for Ground Delivery, 2 for Air Delivery, 3 for Drone Delivery, or 4 for Pigeon Delivery.",
							"Invalid Input", JOptionPane.ERROR_MESSAGE, fedexIcon);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value (1 or 2).",
						"Invalid Input", JOptionPane.ERROR_MESSAGE, fedexIcon);
			}
		}

		// Step 3: Deliver the package and calculate cost
		delivery.calculateCost(pkg);

		// Step 4: Create a customer
		String customerName = JOptionPane.showInputDialog(null, "Enter Customer Name:", "FedEx Customer Input",
				JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();
		String customerAddress = JOptionPane.showInputDialog(null, "Enter Customer Address:", "FedEx Customer Input",
				JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();

		Customer customer = new Customer(customerName, customerAddress);

		JOptionPane.showMessageDialog(null,
				"Customer Created:\n" + "Name: " + customer.getName() + "\n" + "Address: " + customer.getAddress(),
				"FedEx Customer Details", JOptionPane.INFORMATION_MESSAGE, fedexIcon);

		JOptionPane.showMessageDialog(null, "Process completed. Thanks for using the FedEx Package Delivery Simulator!",
				"FedEx Simulator", JOptionPane.INFORMATION_MESSAGE, fedexIcon);
	}
}