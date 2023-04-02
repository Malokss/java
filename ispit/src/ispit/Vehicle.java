package ispit;

public class Vehicle {
    private String manufacturer;
    private String model;
    private int year;
    private String color;
    private String vin;
    private String fuelType;

    public Vehicle(String manufacturer, String model, int year, String color, String vin, String fuelType) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
        this.fuelType = fuelType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getVin() {
        return vin;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Manufacturer: " + manufacturer +
                ", Model: " + model +
                ", Year: " + year +
                ", Color: " + color +
                ", VIN: " + vin +
                ", Fuel Type: " + fuelType;
    }
}
