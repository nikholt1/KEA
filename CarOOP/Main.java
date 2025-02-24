package øvelse1OOP;

public class Main {
    public static void main(String[] args) {
        // Create a Person object
        Person person1 = new Person("Niklas", "Holt", "Läu", 27);

        // Pass the person object as the owner of the car
        Car car1 = new Car("Audi", 2001, person1);

        // Print car details (which includes owner details)
        System.out.println(car1);

        // Start and stop the engine
        System.out.println(car1.startEngine());
        System.out.println(car1.stopEngine());
    }
}
