package ispit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VehicleManager vehicleManager = new VehicleManagerImpl();

		while (true) {
			System.out.println("Vehicle Fleet Management System");
			System.out.println("1. Add a vehicle to the fleet");
			System.out.println("2. Search for vehicles by manufacturer value or model value or VIN value");
			System.out.println("3. Print all vehicles in the fleet");
			System.out.println("4. Delete a vehicle from the fleet");
			System.out.println("5. Quit");
			System.out.print("Enter command: ");

			String command = scanner.nextLine();

			switch (command) {
			case "1":
				addVehicle(scanner, vehicleManager);
				break;
			case "2":
				searchVehicles(scanner, vehicleManager);
				break;
			case "3":
				printAllVehicles(vehicleManager);
				break;
			case "4":
				deleteVehicle(scanner, vehicleManager);
				break;
			case "5":
				System.out.println("Goodbye!");
				return;
			default:
				System.out.println("Invalid command, please try again.");
				break;
			}
		}
	}

	private static void addVehicle(Scanner scanner, VehicleManager vehicleManager) {
		System.out.print("Enter the type of vehicle (car/truck): ");
		String type = scanner.nextLine();
		while (!type.equalsIgnoreCase("car") && !type.equalsIgnoreCase("truck")) {
			System.out.println("Invalid vehicle type. Please enter either 'car' or 'truck'.");
			type = scanner.nextLine();
		}

		System.out.print("Enter the manufacturer of the vehicle: ");
		String make = scanner.nextLine();
		System.out.print("Enter the model of the vehicle: ");
		String model = scanner.nextLine();
		System.out.print("Enter the year of the vehicle: ");
		int year = 0;
		try {
			year = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input format. Please enter a valid year.");
			scanner.nextLine();
			return;
		}
		scanner.nextLine(); // Consume the newline character left by nextInt()
		System.out.print("Enter the color of the vehicle: ");
		String color = scanner.nextLine();
		System.out.print("Enter the VIN of the vehicle: ");
		String vin = scanner.nextLine();
		System.out.print("Enter the fuel type of the vehicle: ");
		String fuelType = scanner.nextLine();

		if (type.equalsIgnoreCase("car")) {
			int numberOfDoors = 0;
			try {
				System.out.print("Enter the number of doors of the car: ");
				numberOfDoors = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input format. Please enter a valid number of doors.");
				scanner.nextLine();
				return;
			}
			scanner.nextLine(); // Consume the newline character left by nextInt()
			System.out.print("Enter the body style of the car: ");
			String bodyStyle = scanner.nextLine();

			Car car = new Car(make, model, year, color, vin, fuelType, numberOfDoors, bodyStyle);
			try {
				vehicleManager.addVehicle(car);
				System.out.println("Car added successfully.");
			} catch (DuplicateVehicleException e) {
				System.out.println("Failed to add car: " + e.getMessage());
			}
		} else if (type.equalsIgnoreCase("truck")) {
			double cargoCapacity = 0.0;
			try {
				System.out.print("Enter the cargo capacity of the truck: ");
				cargoCapacity = scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input format. Please enter a valid cargo capacity.");
				scanner.nextLine();
				return;
			}
			scanner.nextLine(); // Consume the newline character left by nextDouble()

			Truck truck = new Truck(make, model, year, color, vin, fuelType, (int) cargoCapacity);
			try {
				vehicleManager.addVehicle(truck);
				System.out.println("Truck added successfully.");
			} catch (DuplicateVehicleException e) {
				System.out.println("Failed to add truck: " + e.getMessage());
			}
		} else {
			System.out.println("Invalid vehicle type.");
		}
	}

	private static void searchVehicles(Scanner scanner, VehicleManager vehicleManager) {
	    System.out.println("Enter the search term value (manufacturer value or model value or VIN value): ");
	    String searchTerm = scanner.nextLine();
	    List<Vehicle> searchResults = vehicleManager.searchVehicles(searchTerm);
	    if (searchResults.isEmpty()) {
	        System.out.println("No vehicles found.");
	    } else {
	        System.out.println("Search results:");
	        for (Vehicle vehicle : searchResults) {
	            System.out.println(vehicle);
	        }
	    }
	}

	private static void printAllVehicles(VehicleManager vehicleManager) {
		List<Vehicle> vehicles = vehicleManager.getAllVehicles();
		if (vehicles.isEmpty()) {
			System.out.println("No vehicles in fleet.");
		} else {
			System.out.println("Vehicles in fleet:");
			for (Vehicle vehicle : vehicles) {
				System.out.println(vehicle);
			}
		}
	}

	private static void deleteVehicle(Scanner scanner, VehicleManager vehicleManager) {
		System.out.print("Enter the VIN of the vehicle to delete: ");
		String vin = scanner.nextLine();
		try {
			vehicleManager.deleteVehicle(vin);
			System.out.println("Vehicle deleted successfully.");
		} catch (NoSuchVehicleException e) {
			System.out.println("Failed to delete vehicle: " + e.getMessage());
		}
	}

}
