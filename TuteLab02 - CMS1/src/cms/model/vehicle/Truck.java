package cms.model.vehicle;

public class Truck extends Vehicle {
	
	double loadCapacity;
	
	public Truck(String reg, String make, String model, int year, 
			double odometer, double serviceInterval, double loadCapacity ) {
		super(reg, make, model, year, odometer, serviceInterval);
		// TODO Auto-generated constructor stubtedt
		setWear(6);
		this.loadCapacity = loadCapacity;
		
	}

}
