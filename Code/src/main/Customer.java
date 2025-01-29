package main;

public class Customer { // My object is a customer, the one receiving the package.
	// Keeping these private to ensure no one tampers with customer details.
	private String name; // Name of the customer
	private String address; // Address where the package is being delivered

	// Constructor: This is where we set up the customer with placeholder values.
	public Customer(String name, String address) {
		this.name = name; // Set customer’s name
		this.address = address; // set delivery address
	}

	// Getter for customer name
	public String getName() {
		return name;
	}

	// Getter for customer address
	public String getAddress() {
		return address;
	}

	// Setter for customer name with validation
	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Customer name cannot be empty. Try again:");
		}
		this.name = name; // Valid name
	}

	// Setter for customer address with validation
	public void setAddress(String address) {
		if (address == null || address.trim().isEmpty()) {
			throw new IllegalArgumentException("Customer address cannot be empty. Try again:");
		}
		this.address = address; // Valid address
	}

	// Method to validate and set customer input
	public void validateAndSetCustomerDetails(String name, String address) {
		setName(name); // Validate and set name
		setAddress(address); // Validate and set address
	}

	// A method to show customer details in a clean format
	public void printDetails() {
		System.out.println("Customer Name: " + name);
		System.out.println("Address: " + address);
	}
}
