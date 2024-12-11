import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        List<Car> cars= PopulateCarGarage.initializeCarGarage();

        Scanner scanner = new Scanner(System.in);
        int menuOption;

        do {
            displayMenu();

            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1 -> printCars(cars);
                case 2 -> printSpecificCar(cars);
                case 3 -> addNewCar(cars);
                case 4 -> System.out.println("Exit");
                default -> System.out.println("Invalid option, Please try again");
            }
        } while (menuOption != 4);
    }

//add in a code comment here
    private static void displayMenu() {
        System.out.println("\n=== Conal Car Garage===");
        System.out.println("1. Print all cars");
        System.out.println("2. Print Specific car");
        System.out.println("3. Add New car");
        System.out.println("4. Exit");
        System.out.print("Please enter menu choice: ");
    }

    private static void printCars(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }

    public static void addNewCar(List<Car> cars) {
        System.out.println("Enter make:");
        String make = scanner.next();
        System.out.println("Enter model:");
        String model = scanner.next();
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        System.out.println("Enter colour:");
        String colour = scanner.next();
        System.out.println("Enter mileage:");
        double mileage = scanner.nextDouble();

        String license;
        boolean uniqueLicenseFound = false;
        do {
            System.out.println("Enter license plate:");
            license = scanner.next();
            // Check for unique license plate
            if (isLicenseUnique(cars, license)) {
                uniqueLicenseFound = true; // License is unique, exit loop
            } else {
                System.out.println("Error: A car with the same license plate already exists. Please enter a different license plate.");
            }
        } while (!uniqueLicenseFound);

        // At this point, a unique license has been provided
        cars.add(new Car(make, model, year, colour, license, mileage));
        System.out.println("New car added successfully!");
    }

    private static boolean isLicenseUnique(List<Car> cars, String license) {
        for (Car car : cars) {
            if (car.getLicense().equals(license)) {
                return false; // Found a car with the same license, so it's not unique
            }
        }
        return true; // No car with the same license was found, so it's unique
    }

    private static void printSpecificCar(List<Car> cars) {
        System.out.print("Enter the license plate of the car to find: ");
        String license = scanner.next();

        Car foundCar = null;
        for (Car car : cars) {
            if (car.getLicense().equalsIgnoreCase(license)) {
                foundCar = car;
                break;
            }
        }

        if (foundCar != null) {
            System.out.println("Car found:\n" + foundCar.toString());
        } else {
            System.out.println("No car with the license plate '" + license + "' was found.");
        }
    }
}
