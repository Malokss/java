package ispit;

public class Car extends Vehicle {
    private int numberOfDoors;
    private String bodyType;

    public Car(String manufacturer, String model, int year, String color, String vin, String fuelType, int numberOfDoors, String bodyType) {
        super(manufacturer, model, year, color, vin, fuelType);
        this.numberOfDoors = numberOfDoors;
        this.bodyType = bodyType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getBodyType() {
        return bodyType;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Number of doors: " + numberOfDoors +
                ", Body type: " + bodyType;
    }
}
