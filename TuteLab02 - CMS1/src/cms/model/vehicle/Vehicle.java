package cms.model.vehicle;

public abstract class Vehicle {
//	Van(reg, make, model, year, odo, serviceInterval)
	private String reg;
	private String make;
	private String model;
	private int year;
	private double odometer;
	private double serviceInterval;
	private int wear;
	private final double PROFIT_MARGIN = 0.5;
	private double wearTear;
	private double profit;
	private double lastServicePoint;
	private double loadCapacity = 0;
	
	public Vehicle(String reg, String make, String model, int year, double odometer, double serviceInterval) {
		super();
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.year = year;
		this.odometer = odometer;
		this.serviceInterval = serviceInterval;
		
	}
	
	public double getLoadCapacity() {
		return loadCapacity;
	}
	
	public double calcWearTear() {
		return wearTear;
	}

	public int getWear() {
		return wear;
	}

	public void setWear(int wear) {
		this.wear = wear;
	}
	
	
	public double getLastServicePoint() {
		return lastServicePoint;
	}

	public void setLastServicePoint(double lastServicePoint) {
		
		this.lastServicePoint = lastServicePoint;
		System.out.print("last service point has been set to: " + this.lastServicePoint);
	}

	/**
	 * @return the reg
	 */
	public String getReg() {
		return reg;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the odometer
	 */
	public double getOdometer() {
		return odometer;
	}

	/**
	 * @return the serviceInterval
	 */
	public double getServiceInterval() {
		return serviceInterval;
	}

	public double getProfit() {		
		return this.profit * wear;}

	@Override
	public String toString() {
		return "Vehicle [reg=" + reg + ", make=" + make + ", model=" + model + ", year=" + year + ", odometer="
				+ odometer + ", serviceInterval=" + serviceInterval + ", wear=" + wear + ", profit=" + profit + "]";
	}	
}
