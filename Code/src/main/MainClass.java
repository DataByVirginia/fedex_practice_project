package main;

import javax.swing.*;
import java.awt.*;

public class MainClass {
	public static void main(String[] args) {
		// Apply custom FedEx-themed colors and font for JOptionPane
		UIManager.put("OptionPane.background", new Color(102, 0, 153)); // FedEx purple
		UIManager.put("Panel.background", new Color(102, 0, 153)); // Same background
		UIManager.put("OptionPane.messageForeground", Color.WHITE); // White text
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 16)); // Bold font

		// Load FedEx logo and scale it for window
		ImageIcon originalIcon = new ImageIcon("fedex_logo.png");
		Image scaledImage = originalIcon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
		ImageIcon fedexIcon = new ImageIcon(scaledImage);

		// Step 1: Create a package
		String packageId = JOptionPane.showInputDialog(null, "Enter Package ID:", "FedEx Package Input",
				JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();
		String packageDestination = JOptionPane.showInputDialog(null, "Enter Package Destination:",
				"FedEx Package Input", JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();

		Package pkg = new Package(packageId, 0, packageDestination); // Initialize package with ID and destination

		// Loop until a valid weight is entered
		while (true) {
			try {
				String weightInput = JOptionPane.showInputDialog(null, "Enter Package Weight (kg):",
						"FedEx Package Input", JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();
				pkg.validateAndSetWeight(weightInput);
				break; // Exit loop if weight is valid
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE,
						fedexIcon);
			}
		}

		// Display package details
		JOptionPane.showMessageDialog(null,
				"Package Created:\n" + "ID: " + pkg.getId() + "\n" + "Weight: " + pkg.getWeight() + " kg\n"
						+ "Destination: " + pkg.getDestination(),
				"FedEx Package Details", JOptionPane.INFORMATION_MESSAGE, fedexIcon);

		// Step 2: Choose a delivery type
		Delivery delivery = null; // Declare the delivery object

		while (true) {
			try {
				String choiceInput = (String) JOptionPane.showInputDialog(null,
				        "Choose a Delivery Type:\n1. Ground Delivery\n2. Air Delivery\n3. Drone Delivery\n4. Pigeon Delivery",
				        "FedEx Delivery Type", JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null);

				// Handle cancel or close BEFORE parsing input
				if (choiceInput == null) {
					JOptionPane.showMessageDialog(null, "No delivery type selected. Exiting.");
					System.exit(0);
				}

				int choice = Integer.parseInt(choiceInput); // Parse input to integer

				// Assign correct delivery method
				switch (choice) {
					case 1:
						delivery = new GroundDelivery();
						break;
					case 2:
						delivery = new AirDelivery();
						break;
					case 3:
						delivery = new DroneDelivery();
						break;
					case 4:
						delivery = new PigeonDelivery();
						break;
					default:
						JOptionPane.showMessageDialog(null,
								"Invalid choice. Please select 1 for Ground Delivery, 2 for Air Delivery, 3 for Drone Delivery, or 4 for Pigeon Delivery.",
								"Invalid Input", JOptionPane.ERROR_MESSAGE, fedexIcon);
						continue; // Restart loop if invalid input
				}
				break; // Exit loop when valid choice is made
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number (1-4).",
						"Invalid Input", JOptionPane.ERROR_MESSAGE, fedexIcon);
			}
		}

		// Step 3: Calculate cost of specific delivery
		delivery.calculateCost(pkg);

		// Step 4: Create a customer
		String customerName = JOptionPane.showInputDialog(null, "Enter Customer Name:", "FedEx Customer Input",
				JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();
		String customerAddress = JOptionPane.showInputDialog(null, "Enter Customer Address:", "FedEx Customer Input",
				JOptionPane.QUESTION_MESSAGE, fedexIcon, null, null).toString();

		Customer customer = new Customer(customerName, customerAddress);

		// Display customer details
		JOptionPane.showMessageDialog(null,
				"Customer Created:\n" + "Name: " + customer.getName() + "\n" + "Address: " + customer.getAddress(),
				"FedEx Customer Details", JOptionPane.INFORMATION_MESSAGE, fedexIcon);

		// End message
		JOptionPane.showMessageDialog(null, 
		    "Process completed. Thanks for using the FedEx Package Delivery Simulator!", 
		    "FedEx Simulator", JOptionPane.INFORMATION_MESSAGE, fedexIcon);

		
		// Ferris Bueller's Day Off Easter Egg - Delayed Exit Messages
		try {
		    Thread.sleep(1000); // Pause for 1 second
		    JOptionPane.showMessageDialog(null, "You're still here?", "FedEx Simulator", JOptionPane.INFORMATION_MESSAGE, fedexIcon);
		    
		    Thread.sleep(1200); // Slightly longer pause
		    JOptionPane.showMessageDialog(null, "It's over.", "FedEx Simulator", JOptionPane.INFORMATION_MESSAGE, fedexIcon);
		    
		    Thread.sleep(1400); // Build up the effect
		    JOptionPane.showMessageDialog(null, "Go home...", "FedEx Simulator", JOptionPane.INFORMATION_MESSAGE, fedexIcon);
		    
		    Thread.sleep(1600); // Final dramatic pause
		    JOptionPane.showMessageDialog(null, "Go.", "FedEx Simulator", JOptionPane.INFORMATION_MESSAGE, fedexIcon);
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt(); // Restore the interrupted status (clean handling)
		}
		
	}
}
