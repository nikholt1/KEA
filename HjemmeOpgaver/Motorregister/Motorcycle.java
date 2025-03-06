package motorrigister.models;

public class Motorcycle extends Vehicle{
    private int engineSize;

    public Motorcycle(String licensePlate, String brand, int year, int mileage, int engineSize, String owner){
        super(licensePlate, brand, year, mileage, owner);
        this.engineSize = engineSize;
    }

    public int getEngineSize() {
        return engineSize;
    }
    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
    public void printInfo() {
        System.out.println("lisenceplate = " + getLicensePlate() + " brand = " + getBrand() + " year = " + getYear() + " mileage = " + getMileage() + " fuelType = " + engineSize + " owner = " + getOwner());
    }
}
