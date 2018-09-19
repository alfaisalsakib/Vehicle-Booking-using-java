package bookingCarVan;

/*
 * 
 * car class specify the car vehicle
 * 
 */

public class Car extends Vehicle
{
	
	private int totalDays;
	private int BookingNumber;
	
	public Car()
	{
		//a default constructor
	}
	
	public Car(String registrationNumber, String make, String model)
	{
		super(registrationNumber, make, model); // super class attribute have to be initialized in sub class
	}
	/*
	 * 
	 * setter and getter of car class
	 */
	public int getTotalDays()
	{
		return totalDays;
	}

	public void setTotalDays(int totalDays) 
	{
		this.totalDays = totalDays;
	}
	
	public int getBookingNumber() 
	{
		return BookingNumber;
	}

	public void setBookingNumber(int bookingNumber) 
	{
		BookingNumber = bookingNumber;
	}

	
	//calculate the total cost of car type vehicle
	public double usageCost() 
	{
		return (totalDays * 50.0);
	}

}
