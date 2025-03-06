package motorrigister;

import motorrigister.models.Car;
import motorrigister.models.Motorcycle;
import motorrigister.services.Registry;

public class Main {


    public static void main(String[] args) {
        Registry registry1 = new Registry(4);
        Car BMW = new Car("BJ6969", "BWM", 2007, 20000, "Benzin", "Niklas Holt Läu");
        Motorcycle Yamaha = new Motorcycle("BJ9696", "Yamaha", 2001, 20000, 600, "Niklas");

        registry1.addVehicle(BMW);
        registry1.addVehicle(Yamaha);

        registry1.listVehicles();

    }
}
