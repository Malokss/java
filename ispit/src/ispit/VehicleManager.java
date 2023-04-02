package ispit;

import java.util.List;

public interface VehicleManager {
    
    void addVehicle(Vehicle vehicle) throws DuplicateVehicleException;
    
    List<Vehicle> searchVehicles(String manufacturer, String model, String vin);
    
    List<Vehicle> getAllVehicles();
    
    void deleteVehicle(String vin) throws NoSuchVehicleException;

	List<Vehicle> searchVehicles(String searchTerm);
}


