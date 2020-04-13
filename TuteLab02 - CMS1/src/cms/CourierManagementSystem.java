package cms;

import java.util.ArrayList;
import java.util.Collection;

import cms.model.vehicle.Truck;
import cms.model.vehicle.Van;
import cms.model.vehicle.Vehicle;

public class CourierManagementSystem {
	
	
	
	//collection of vehicles 
	public static Collection<Vehicle> fleet=new ArrayList<Vehicle>();
	
	public static double calcWear(Vehicle vehicle) {
		double wear  = vehicle.getWear();		
		return wear;
	}
	
	//adds vehicle to the CMS - Section C
	public Vehicle addVehicle(Van van) {
		// TODO Auto-generated method stub
//		System.out.println("Van has been added to the system");
		System.out.println("Modle Name: " + van.getModel() + " has been added to the collection");
		fleet.add(van);
		return van;
		
	}	
	//adds vehicle to the CMS - Section C

	public Vehicle addVehicle(Truck truck) {
		// TODO Auto-generated method stub
//		System.out.println("Truck has been added to the system with model: " + truck.getModel());
		System.out.println("Modle Name: " + truck.getModel() + " has been added to the collection");
		fleet.add(truck);
		return truck;
		
	}	
	
	//schedules a job for a vehicle
	public boolean scheduleJob(double distance, Vehicle vehicle) {
		// TODO Auto-generated method stub
		//check if 
		double odo = vehicle.getOdometer();
		double serviceInt = vehicle.getServiceInterval();
		double lastService = vehicle.getLastServicePoint();
		double nextServicePoint = lastService + serviceInt;
		double remainCap = nextServicePoint - odo;
		double wearTear;
//		double remainCap = lastService - odoLessSp;
		
		System.out.println("next service point " + nextServicePoint);
		System.out.println("job capicity is: " + remainCap);
		if (remainCap < distance) {
			System.out.println("next service point " + nextServicePoint);
			System.out.println("job capicity is: " + remainCap);
			System.out.println("distance is: " + distance);
			System.out.println("Vehicle does not have suffient capactity for job");
			return false;
		}
		else {
			System.out.println("next service point " + nextServicePoint);
			System.out.println("job capicity is: " + remainCap);
			System.out.println("distance is: " + distance);
			System.out.println("Vehicle has capacity for this job");
			double wear = vehicle.getWear();
			if (vehicle instanceof Van) {
				wearTear = vehicle.getWear() * distance / 100;
				System.out.println("Van wear and tear: " + wearTear);
			}
			else {
				wearTear = vehicle.getWear() * vehicle.getLoadCapacity() / 100;
				System.out.println("Truck wear and tear: " + wearTear);
			}
			
			
		return true;}
	}
	// displays information about a vehicle
	public String displayVehicleInfo(Vehicle vehicle) {
		String message = vehicle.toString();
		// TODO Auto-generated method stub
		return message;
		
	}

	public void displayAllVehicles() {
		// display information for all vehicles in collectoin
		System.out.println("Displaying information on the current Fleet");
	    for(Vehicle vehicle : fleet)  
	        System.out.println(vehicle);
	    }
	

	public void serviceVehicle(Vehicle vehicle) {
		//once vehichle has been serviced the service point is updated with odometer;
		System.out.println("current Service Point" + vehicle.getLastServicePoint());
		vehicle.setLastServicePoint(vehicle.getOdometer());
		System.out.println("Vehicle has been serviced");
		System.out.println("Updated Service Point" + vehicle.getLastServicePoint());
		// TODO Auto-generated method stub
		
	}

	public void displayAllJobs() {
		// TODO Auto-generated method stub
		
	}

}
