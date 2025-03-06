package motorrigister.models;

public class Vehicle {
    private String licensePlate;
    private String brand;
    private int year;
    private int mileage;

    private String owner;

    public Vehicle(String licensePlate, String brand, int year, int mileage, String owner) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
        this.owner = owner;
    }

    public void drive(int km) {
        if (km < 0) {
            System.out.println("km must be over 0");

        } else {
            mileage += km;
        }
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getOwner() {
        return owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public String getBrand() {
        return brand;
    }
    public int getYear() {
        return year;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        if (mileage < 0) {
            System.out.println(" mileage must be over 0");
        } else {
            this.mileage = mileage;
        }

    }
    public void printInfo() {
        System.out.println("lisence plate =" + licensePlate + " brand = " + brand + " year = " + year + " mileage = " + mileage + " owner = " + owner);
    }
}
