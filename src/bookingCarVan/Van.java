package bookingCarVan;

public class Van extends Vehicle
{

	private int totalDays; //count the total days of van 
	private int BookingNumber; //count the total number of booking

	public Van()
	{
	//a default constructor	
	}
	
	public Van(String registrationNumber, String make, String model) 
	{
		super(registrationNumber, make, model);
	}
	
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
	
	//calculate the total cost of van type vehicle
	public double usageCost()
	{
		double fare = 0;
		int tempDay;
		
		if(totalDays >= 1 && totalDays <= 5)
		{
			fare = 100 * totalDays;
		}
		else if(totalDays > 5)
		{
			tempDay = totalDays - 5;
			fare = 500 + (tempDay*20) + (tempDay*100);
		}
		return fare;
	}
	
}
