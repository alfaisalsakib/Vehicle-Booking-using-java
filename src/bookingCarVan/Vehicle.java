package bookingCarVan;

/*
 * 
 * A abstract class is vehicle 
 * 
 */

public abstract class Vehicle 
{
	private String registrationNumber;
	private String make;
	private String model;
	company c;
	Booking b;
	
	public Vehicle()
	{
		// default constructor
	}
	
	public Vehicle(String registrationNumber, String make, String model) 
	{
		this.registrationNumber = registrationNumber;
		this.make = make;
		this.model = model;
	}
		
	public company getC() 
	{
		return c;
	}

	public void setC(company c)
	{
		this.c = c;
	}

	public Booking getB()
	{
		return b;
	}

	public void setB(Booking b) 
	{
		this.b = b;
	}

	public String getRegistrationNumber() 
	{
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) 
	{
		this.registrationNumber = registrationNumber;
	}
	public String getMake() 
	{
		return make;
	}
	public void setMake(String make)
	{
		this.make = make;
	}
	public String getModel()
	{
		return model;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	
	//abstractor class will be implemented in the sub class
	public abstract double usageCost(); 
	
	
}
