package motorrigister.services;

import motorrigister.models.Vehicle;

public class Registry {
    public Vehicle[] vehicles;
    private int count;


    public Registry(int maxVehicles) {
        this.vehicles = new Vehicle[maxVehicles];

    }
    public void addVehicle(Vehicle v) {
//        if (vehicles[count] == null) {
//            vehicles[count] = v;
//            count++;
//        }
        for (int i = 0; count < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = v;
                count++;
                break;
            } else {
                System.out.println("registry is full");
                break;
            }
        }
    }
    public void listVehicles(){
        for (int i = 0; i < count; i++) {
            if (vehicles[i] == null) {
                System.out.println("Array is empty");
            } else {
                vehicles[i].printInfo();
            }

        }
    }

}
