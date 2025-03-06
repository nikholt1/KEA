package motorrigister.models;

public class Car extends Vehicle{

    private String fuelType;

    public Car(String licensePlate, String brand, int year, int mileage, String fuelType, String owner) {
        super(licensePlate, brand, year, mileage, owner);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void printInfo() {
        System.out.println("lisenceplate = " + getLicensePlate() + " brand = " + getBrand() + " year = " + getYear() + " mileage = " + getMileage() + " fuelType = " + fuelType + " owner = " + getOwner());
    }
}
