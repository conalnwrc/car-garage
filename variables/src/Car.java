import java.util.Calendar;

public class Car {
    private String make;
    private String model;
    private int year;
    private String colour;
    private String license;

    private double mileage;

    private boolean isRunning;

    // Constructor
    public Car(String make, String model, int year, String colour, String license, double mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.colour = colour;
        this.license = license;
        this.mileage = mileage; // New car, mileage is initialized to 0
        this.isRunning = false; // Car is initially not running
    }


    public Car(){}

    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("The " + make + " " + model + " has been started.");
        } else {
            System.out.println("The " + make + " " + model + " is already running.");
        }
    }

    // Method to stop the car
    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println("The " + make + " " + model + " has been stopped.");
        } else {
            System.out.println("The " + make + " " + model + " is already stopped.");
        }
    }

    // Method to drive the car a certain distance
    public void drive(double distance) {
        if (isRunning) {
            mileage += distance;
            System.out.println("The " + make + " " + model + " has been driven " + distance + " miles.");
        } else {
            System.out.println("Cannot drive. The " + make + " " + model + " is not running.");
        }
    }
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
            if (model.length() > 15) {
                // Throw an IllegalArgumentException with a message
                throw new IllegalArgumentException("Model cannot be longer than 15 characters.");
            }
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        // Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Check if the year is within the valid range
        if (year >= 1950 && year <= currentYear) {
            this.year = year;
        } else {
            //System.out.println("Invalid year. Please enter a year between 1950 and " + currentYear + ".");
            throw new IllegalArgumentException("Invalid year. Please enter a year between 1950 and " + currentYear + ".");
            // You can throw an exception or handle the error in a different way based on your application's requirements
        }
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }


    @Override
    public String toString() {
        return "Car: " +
                "\nmake='" + make + '\'' +
                "\nmodel='" + model + '\'' +
                "\nyear=" + year +
                "\ncolor='" + colour + '\'' +
                "\ncolor='" + license + '\'' +
                "\nmileage=" + mileage
                +"\n";
    }
}



