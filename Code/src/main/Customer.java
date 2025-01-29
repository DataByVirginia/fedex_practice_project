package main;

public class Customer { // My object is a customer, the one receiving the package.
	// Keeping these private to ensure no one tampers with customer details.
	private String name; // Name of the customer
	private String address; // Address where the package is being delivered

	// Constructor: Initializes the customer with the given details.
	public Customer(String name, String address) {
		this.name = name; // Set customer’s name
		this.address = address; // set delivery address
	}

	// Getters let us access private attributes safely (read-only).  
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	// Setters ensure only valid updates happen (no blank names or addresses).  
	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Customer name cannot be empty. Try again:");
		}
		this.name = name; // Valid name
	}

	public void setAddress(String address) {
		if (address == null || address.trim().isEmpty()) {
			throw new IllegalArgumentException("Customer address cannot be empty. Try again:");
		}
		this.address = address; // Valid address
	}

	// This method ensures both name and address are validated before being set (you wouldn't want to set and regret it)
	public void validateAndSetCustomerDetails(String name, String address) {
		setName(name); // Validate and set name
		setAddress(address); // Validate and set address
	}

	// A method to output the customer details
	public void printDetails() {
		System.out.println("Customer Name: " + name);
		System.out.println("Address: " + address);
	}
}
