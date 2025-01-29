package main;

/*
 I don't want these main attributes to be accessible by any Joe-shmo.  
 Instead of letting anyone change them directly (which could break stuff),  
 I'll keep them private and use encapsulation (getters/setters) to control access.  
 That way, I can validate data, enforce rules, and keep everything running smoothly without constant cleanup.  
*/

public class Package { // my object is package

	private String id; // unique id
	private double weight; // carriers use decimals for weight, so I will too
	private String destination; // the point b -- delivery destination

	// initialize package with a constructor
	//This is where we use encapsulation to take the private attributes and let others play w/and change them
	public Package(String id, double weight, String destination) {
		this.id = id;
		this.weight = weight;
		this.destination = destination; // 'this' is the object we're in.  
						// Similar to aliasing in SQL (AAD.dbo.t_tran_log AS tl) to shorten references  
						// and ensure we pull from the right place when multiple sources overlap.
	}

// Getters let us safely access private attributes without exposing them directly (similar to "read-only")
	
	public String getId() {
		return id; // returning the unique package ID
	}

	public double getWeight() {
		return weight; // returns the current weight
	}

	public String getDestination() {
		return destination; // returns the stored delivery destination
	}

// Setters are the sheriffs of this here town! They control what gets updated, making sure nothing shady sneaks past.

	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			throw new IllegalArgumentException("Weight must be a positive number. Try again:");
		}
	}

// This method validates user input before updating weight. 
// If the input isn't a valid number, it's tossed out, and the main re-prompts

	public void validateAndSetWeight(String input) {
		try {
			double parsedWeight = Double.parseDouble(input); // Parse from String to number
			setWeight(parsedWeight); // Use the setter to validate and set the weight
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid input! Please enter a numeric value for weight:");
		}
	}

	public void setDestination(String destination) {
		this.destination = destination; // No sheriffs needed ATM. Can update PRN.
	}

	// This method will output a quick summary of the package -- inputs to be given in MainClass
	public void printDetails() {
		System.out.println("Package ID: " + id);
		System.out.println("Weight: " + weight + " lbs");
		System.out.println("Destination: " + destination);
	}
}
