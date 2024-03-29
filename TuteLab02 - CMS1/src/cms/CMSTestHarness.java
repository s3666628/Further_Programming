package cms;
import cms.model.vehicle.Truck;
import cms.model.vehicle.Van;
import cms.model.vehicle.Vehicle;

/**
 * <b> CMSTestHarness </b> performs the following functionalities on the courier
 * management system.
 * 
 * - Add Vehicle (Vans + Trucks). - Display Information about a Vehicle(s). -
 * Assign a vehicle to a job (tests cases in which a job should be accepted and
 * a case where it should be refused) - Service a vehicle - Display Information
 * about Job(s)
 * 
 * Original author unknown: refactored by Caspar s1 2018
 */
public class CMSTestHarness
{
	// this implies an interface or abstract class but since not covered until next week you can change to
	// CourierManagementSystem cms = new CourierManagementSystem() if you prefer
	// (it will get updated in the next tutelab week anyway!)
	final protected static CourierManagementSystem cms = new CourierManagementSystemImpl();

	/**
	 * simple helper method to log job schedule details
	 * 
	 * @param reg of the vehicle
	 * @param distance distance to schedule
	 * @param schedule whether we expect this test to be scheduled or reject
	 */
//	protected static boolean testSchedule(String reg, double distance, boolean schedule)
//	{
//		boolean scheduled = cms.scheduleJob(distance, reg);
//		System.out.printf("Job %.02fkm to %s (should %s) = %s\n", distance, reg, schedule ? "schedule" : "reject",
//				scheduled ? "scheduled" : "rejected");
//		return scheduled;
//	}

	public static void main(String[] args)
	{
		// Van(reg, make, model, year, odo, serviceInterval)
		
		// Create some new Vans and Trucks
		Vehicle van1 = cms.addVehicle(new Van("F4", "Nissan", "Van Master", 2020, 33449.0, 20000));
		Vehicle van2 = cms.addVehicle(new Van("T1", "Ford", "Transit", 2019, 5000.0, 500.0));			
		Vehicle truck1 = cms.addVehicle(new Truck("D3", "Ford", "447", 2005, 0.0, 2000.0, 3500));
		Vehicle truck2 = cms.addVehicle(new Truck("A4", "Scania", "BigRig", 2005, 0.0, 2000.0, 3500));

		// Display Vehicle Information
		System.out.format("\n*Printing Information for a Vehincle : %s\n", "F4");
		System.out.format(van1.toString());


		// Display All Vehicles
		System.out.println("\n*Displaying All Vehicles...");
		cms.displayAllVehicles();

		// Schedule Jobs for V2
//		System.out.println("\n*Scheduling...");
//		testSchedule("v2", 100, true);
//		testSchedule("v2", 600, true);
//		testSchedule("v2", 500, false);
//		testSchedule("v2", 100, true);
//		testSchedule("v2", 300, false);
		// set last service point for van
		van1.setLastServicePoint(14449);
		
		System.out.print(cms.scheduleJob(999.0, van1));
		
		

		// Printing current Odometer reading and vehicle information for van v2
		System.out.format("\n*Vehicle Information for %s (After Jobs Scheduled)...\n", "v2");
//		cms.displayVehicleInfo("v2");

		// Servicing V2
		System.out.format("\n*Servicing Vehicle...\n");
		System.out.print(cms.displayVehicleInfo(van1));
		cms.serviceVehicle(van1);
		
//		cms.serviceVehicle("v2");
//		cms.displayVehicleInfo("v2");

		// Final schedule test after servicing
//		testSchedule("v2", 990, true);

		System.out.println("\n*Displaying All Scheduled Jobs");
		cms.displayAllJobs();
	}
}
