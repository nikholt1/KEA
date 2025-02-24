package øvelse1OOP;

public class Car {
    String brand;
    int year;
    Person owner;

    // Constructor that assigns brand, year, and owner
    public Car(String brand, int year, Person owner) {
        this.brand = brand;
        this.year = year;
        this.owner = owner;
    }

    public String toString() {
        return "Car: " + brand + " (" + year + "), Owner: " + (owner != null ? owner.getFullName() : "No owner");
    }

    public String startEngine() {
        return "The engine starts...";
    }

    public String stopEngine() {
        return "The engine stops...";
    }
}
