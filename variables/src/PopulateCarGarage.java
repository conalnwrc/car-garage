
import java.util.ArrayList;
import java.util.List;

public class PopulateCarGarage {

    public static List<Car> initializeCarGarage(){
        List<Car> cars = new ArrayList<>();

            // Attempt to create an instance of YourClass

            Car car1 = new Car("Audi", "A4", 2010, "red", "UNZ1234", 120000);
            Car car2 = new Car("VW", "Golf", 2013, "silver", "UNZ1255", 70000);
            Car car3 = new Car("VW", "Golf", 1940, "silver", "UNZ1266", 70000);

            cars.add(car1);
            cars.add(car2);
            cars.add(car3);

        return cars;
    }
}
