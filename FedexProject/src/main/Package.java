package main;

public class Package { // my object is package
	// I don't want these main attributes to be accessible by any Joe-shmo
	// I don't want to have to clean-up behind, maintain, or otherwise deal with all
	// the Joe's shmoie behavior
	// So it will be private and 'they' (alter-ego Virginia and others) can use
	// encapsulation to access
	private String id; // unique id
	private double weight; // carriers use decimals for weight, so I will too
	private String destination; // the point b -- delivery destination

	// initialize package with a constructor
	// this is where we use encapsulation to take the private attributes and let
	// others play w/and change them
	public Package(String id, double weight, String destination) {
		this.id = id;
		this.weight = weight;
		this.destination = destination; // 'this' is the object we're in -- faster
		// like renaming a long database/table path: AAD.dbo.t_tran_log AS tl in SQL

		// we've made a container for the info we need to hold about an object
		// but who's going to retrieve it?
		// Answer: Getters. These homies are going to act as bouncers:
		// checking for the appropriate requirements to let them access the fields and
		// 'get' info
	}

	public String getId() {
		return id;
	}

	public double getWeight() {
		return weight;
	}

	public String getDestination() {
		return destination;
	}

	// setters are the ones that take what was 'gotten' and allow it to be changed:
	// WITH RULES
	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			throw new IllegalArgumentException("Weight must be a positive number. Try again:");
		}
	}

	// Encapsulate input validation for weight in this helper method
	public void validateAndSetWeight(String input) {
		try {
			double parsedWeight = Double.parseDouble(input); // Attempt to parse the input
			setWeight(parsedWeight); // Use the setter to validate and set the weight
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid input! Please enter a numeric value for weight:");
		}
	}

	public void setDestination(String destination) {
		this.destination = destination; // Update the destination -- no need to over complicate things for this dip back
										// in
	}

	// This method will output a quick summary of the package -- inputs to be given
	// in MainClass
	public void printDetails() {
		System.out.println("Package ID: " + id);
		System.out.println("Weight: " + weight + " lbs");
		System.out.println("Destination: " + destination);
	}
}
