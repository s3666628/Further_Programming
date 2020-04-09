package cms;

import vehicles.Truck;
import vehicles.Van;
import vehicles.Vehicle;

public class CourierManagementSystem {

	public Vehicle addVehicle(Van van) {
		// TODO Auto-generated method stub
		System.out.println("Van has been added to the system");
		return van;
		
	}

	public Vehicle addVehicle(Truck truck) {
		// TODO Auto-generated method stub
		System.out.println("Truck has been added to the system with model: " + truck.getModel());
		return truck;
		
	}

	public boolean scheduleJob(double distance, String reg) {
		// TODO Auto-generated method stub
		return false;
	}

	public void displayVehicleInfo(Vehicle vehicle) {
		String message = vehicle.toString();
		// TODO Auto-generated method stub
		
	}

	public void displayAllVehicles() {
		// TODO Auto-generated method stub
		
	}

	public void serviceVehicle(String string) {
		// TODO Auto-generated method stub
		
	}

	public void displayAllJobs() {
		// TODO Auto-generated method stub
		
	}

}
