package bookingCarVan;

/*
 * 
 * 
 * Booking class specify the department name, starting date, Ending date of any vehicle 
 * 
 */

public class Booking 
{
	private String deptName;
	private String DateFrom;
	private String DateTo;
	private String Name; //vehicle maker name helps to track with the vehicle name
	
	public Booking(String deptName, String dateFrom, String dateTo) 
	{
		this.deptName = deptName;
		DateFrom = dateFrom;
		DateTo = dateTo;
	}

	/*
	 * setter and getter of the attributes of booking class 
	 * 
	 */
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDeptName() 
	{
		return deptName;
	}

	public void setDeptName(String deptName) 
	{
		this.deptName = deptName;
	}

	public String getDateFrom() 
	{
		return DateFrom;
	}

	public void setDateFrom(String dateFrom)
	{
		DateFrom = dateFrom;
	}

	public String getDateTo() 
	{
		return DateTo;
	}

	public void setDateTo(String dateTo) 
	{
		DateTo = dateTo;
	}
	
	public void PrintBooking() //print the main attribute of  booking class
	{
		System.out.println("Department : " + deptName);
		System.out.println("Date From  : " + DateFrom);
		System.out.println("Date To    : " + DateTo);
	}
	
}
