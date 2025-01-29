**FedEx Package Delivery Simulator**

This Java-based package delivery simulator allows users to enter package details, choose a delivery method, and get a cost estimate. It uses JOptionPane for the interface instead of the console. The program applies object-oriented programming (OOP) principles to keep the design flexible and maintainable.



__Project Overview__
- Allows users to enter package details like ID, weight, and destination
- Supports multiple delivery methods, including Ground, Air, Drone, and Pigeon
- Calculates and displays the delivery cost based on the selected method
- Handles courier details automatically in the background



__OOP Principles in This Project__

  **Encapsulation** ensures that critical data is kept private and only accessed through controlled methods. The weight of the package, for example, is private so it cannot be modified directly. Instead, a setter method checks that only valid numbers are assigned. This prevents errors like negative weights or non-numeric input.

  **Inheritance** prevents repeating the same code for different delivery types. Instead of writing separate logic for each one, a parent class called Delivery is created, and GroundDelivery, AirDelivery, DroneDelivery, and PigeonDelivery inherit from it. Each delivery type only has to define its own cost formula, while the rest of the structure remains the same.

  **Polymorphism** allows one variable to take on different forms. In this project, the delivery variable can represent different delivery types depending on user selection. This means the same method call works for all delivery types without needing separate if-else blocks in multiple places. If a new delivery method needs to be added, it can extend Delivery and work with the existing code without changing other parts of the program.

  **Abstraction** is used to simplify the design by making Delivery an abstract class. This means it provides a general structure but does not define the specific cost calculations. Those details are left to the individual delivery types. The user does not need to know how cost is calculated internally, only that they will receive a final price.



__How to Run the Project__
- Clone the repository using git clone followed by the GitHub URL
- Open the project in VS Code, IntelliJ, or Eclipse
- Run MainClass.java



__Future Improvements__
- Store delivery history in a database
- Integrate a tracking API to simulate real-world shipping
- Create a chatbot to answer basic questions



__Final Thoughts__
This project is a simple but effective example of using encapsulation, inheritance, polymorphism, and abstraction in Java. The design allows for easy expansion while keeping the main logic clean.
