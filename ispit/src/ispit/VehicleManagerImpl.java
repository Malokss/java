package ispit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleManagerImpl implements VehicleManager {
	private static final Logger LOGGER = Logger.getLogger(VehicleManagerImpl.class.getName());

	private Map<String, Vehicle> fleet; // mapa VIN oznaka i vozila

	public VehicleManagerImpl() {
		fleet = new HashMap<>();
	}

	@Override
	public void addVehicle(Vehicle vehicle) throws DuplicateVehicleException {
		if (fleet.containsKey(vehicle.getVin())) {
			throw new DuplicateVehicleException("Vehicle with VIN " + vehicle.getVin() + " already exists.");
		}
		fleet.put(vehicle.getVin(), vehicle);
		LOGGER.log(Level.INFO, "Added vehicle with VIN: {0}", vehicle.getVin());
	}

	@Override
	public List<Vehicle> searchVehicles(String manufacturer, String model, String vin) {
		List<Vehicle> results = new ArrayList<>();
		for (Vehicle vehicle : fleet.values()) {
			if ((manufacturer == null || manufacturer.equals(vehicle.getManufacturer()))
					&& (model == null || model.equals(vehicle.getModel()))
					&& (vin == null || vin.equals(vehicle.getVin()))) {
				results.add(vehicle);
			}
		}
		LOGGER.log(Level.INFO, "Search for vehicles with manufacturer: {0}, model: {1}, VIN: {2} returned {3} results",
				new Object[] { manufacturer, model, vin, results.size() });
		return results;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return new ArrayList<>(fleet.values());
	}

	@Override
	public void deleteVehicle(String vin) throws NoSuchVehicleException {
		if (!fleet.containsKey(vin)) {
			throw new NoSuchVehicleException("Vehicle with VIN " + vin + " does not exist.");
		}
		fleet.remove(vin);
		LOGGER.log(Level.INFO, "Removed vehicle with VIN: {0}", vin);
	}

	@Override
	public List<Vehicle> searchVehicles(String searchTerm) {
		List<Vehicle> matchingVehicles = new ArrayList<>();

		for (Vehicle vehicle : fleet.values()) {
			if (vehicle.getManufacturer().equals(searchTerm) || vehicle.getModel().equals(searchTerm)
					|| vehicle.getVin().equals(searchTerm)) {
				matchingVehicles.add(vehicle);
			}
		}
		 LOGGER.log(Level.INFO, "Search for vehicles with search term {0} returned {1} results",
	                new Object[] { searchTerm, matchingVehicles.size() });
		return matchingVehicles;
	}

}
