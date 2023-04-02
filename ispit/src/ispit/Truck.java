package ispit;

public class Truck extends Vehicle {
    private int cargoCapacity;

    public Truck(String manufacturer, String model, int year, String color, String vin, String fuelType, int cargoCapacity) {
        super(manufacturer, model, year, color, vin, fuelType);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Cargo capacity: " + cargoCapacity;
    }
}
