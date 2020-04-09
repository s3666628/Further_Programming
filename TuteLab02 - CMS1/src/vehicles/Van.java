package vehicles;

public class Van extends Vehicle{

	public Van(String reg, String make, String model, int year, double odometer, double serviceInterval) {
		super(reg, make, model, year, odometer, serviceInterval);
		// TODO Auto-generated constructor stub
		setWear(60);
	}
	

}
