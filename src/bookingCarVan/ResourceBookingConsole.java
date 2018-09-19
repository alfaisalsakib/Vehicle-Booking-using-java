package bookingCarVan;

import java.util.*;
import java.io.*;

public class ResourceBookingConsole
{
	private company cm;
	int countBooking; // counts the total booking 
	
	List<Booking> bk = new ArrayList<>(); //a list of booking class
	List<Vehicle> Vh = new ArrayList<>(); // a list of vehicle class
	List<Car> cr = new ArrayList<>(); // a list of car class
	List<Van> vn = new ArrayList<>(); // a list of van class
	Scanner input = new Scanner(System.in); 
	
	public ResourceBookingConsole(){
		//default constructor
	}
	
	// through parameter value of different lists comes in
	public void BookingConsole(List<Vehicle> v,List<Car> c,List<Van> van,company cm)
	{
		Vh = v;
		cr = c;
		vn = van;
		
		this.cm = cm;
		int op;
		String VhMake;
		String day;
		
		Booking b;
		Vehicle vc;
		String department,From,To;		
			
		System.out.println("<< Enter the vehicle type (Car/Van) you choose for booking >>");
		System.out.println("Press 1 >> Car");
		System.out.println("Press 2 >> Van");
		op = input.nextInt();
		
		if(op == 1)
		{
			System.out.println("<< Available cars  are with the maker company of the car>>");
			
			try // using file to save data parmanently
			{
				FileWriter fw = new FileWriter("VehicleInfo.txt",true); //vehicle reg. No, model, maker company is specified
				FileWriter fww = new FileWriter("Days.txt",true); // the booking dates is specified
				
				for(Vehicle ve:Vh)
				{
					System.out.println(ve.getMake()); // getting only the maker of the vehicle
				}
				
				/*
				 * 
				 * writting data to the file
				 */
				
				System.out.println("<< Enter the Car Maker Name >>");
				VhMake = input.nextLine();
				VhMake = input.nextLine();
				fw.write(VhMake);
				fw.write("\r\n");
				fww.write(VhMake);
				fww.write("\r\n");
				
				System.out.println("<< Enter the Department >>");
				department = input.nextLine();
				fw.write(department);
				fw.write("\r\n");
				
				System.out.println("<< Enter the Starting Date >>");
				From = input.nextLine();
				fw.write(From);
				fw.write("\r\n");
				
				System.out.println("<< Enter the Ending Date >>");
				To = input.nextLine();
				fw.write(To);
				fw.write("\r\n");
				
				System.out.println("<< Mention the days >>");
				day = input.nextLine();
				fww.write(day);
				fww.write("\r\n");
				
				
				fww.close();
				fw.close();
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
			
			DataEntryToList(); //after the file initializing data will be entered to the lists
			
		}
		else if(op == 2)
		{
			System.out.println("<< Avaiable Vans are with the company that make it >>");
			
			try
			{
				FileWriter fw = new FileWriter("VehicleInfo.txt",true);
				
				for(Vehicle ve:Vh)
				{
					System.out.println(ve.getMake());
				}
				
				System.out.println("<< Enter the Van Maker Name >>");
				VhMake = input.nextLine();
				VhMake = input.nextLine();
				fw.write(VhMake);
				fw.write("\r\n");
				
				System.out.println("<< Enter the Department >>");
				department = input.nextLine();
				fw.write(department);
				fw.write("\r\n");
				
				System.out.println("<< Enter the Starting Date >>");
				From = input.nextLine();
				fw.write(From);
				fw.write("\r\n");
				
				System.out.println("<< Enter the Ending Date >>");
				To = input.nextLine();
				fw.write(To);
				fw.write("\r\n");
				
				fw.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
			
			DataEntryToList();
		}
		else 
		{
			System.out.println("<< Invalid Option >>");
		}
		
		System.out.println("<< DO YOU WANT DELETE ANY VEHICLE from your company >>");
		System.out.println("Press 1 >> Yes");
		System.out.println("Press 2 >> No");
		op = input.nextInt();
		
		if(op == 1)
		{
			System.out.println("<< What vehicle you want to delete >>");
			System.out.println("Press 1 >> Car");
			System.out.println("Press 2 >> Van");
			op = input.nextInt();
			
			System.out.println("<< Enter the Car Maker (EX::BMW/Honda) Name >>");
			VhMake = input.nextLine();
			VhMake = input.nextLine();
			
			
			if(op == 1)
			{
				countBooking = CountBooking(VhMake); //a mathod that count the total booking
				System.out.println("This car contains " + countBooking + " bookings.");
				System.out.println("Do You want to delete it?");
				System.out.println("press 1 >> yes");
				System.out.println("Press 2 >> No");
				op = input.nextInt();
				
				if(op == 1)
				{
					int s=0;
					for(Vehicle ve:Vh)
					{
						if(ve.getMake().equals(VhMake))
						{
							break;
						}
						s++;
					}
					
					Vh.remove(s); // removing the data
				}
			}
			else if(op == 2)
			{
				countBooking = CountBooking(VhMake);
				System.out.println("This van contains " + countBooking + " bookings.");
				System.out.println("Do You want to delete it?");
				System.out.println("press 1 >> yes");
				System.out.println("Press 2 >> No");
				op = input.nextInt();
				
				if(op == 1)
				{
					int s=0;
					for(Vehicle ve:Vh)
					{
						if(ve.getMake().equals(VhMake))
						{
							break;
						}
						s++;
					}
					
					Vh.remove(s);
				}
			}
			
		
		}
		else if(op != 2)
		{
			System.out.println("<< Invalid Option >>");
		}
		
		System.out.println("<< Updated List with the details of the vehicles >>"); //printing the data respectively
		for(Vehicle ve:Vh)
		{
			System.out.println("Regestration No. : "+ve.getRegistrationNumber());
			System.out.println("Car Maker        : "+ve.getMake());
			System.out.println("Car Model        : "+ve.getModel());
		}
		
		System.out.println("<< Enter Vehicle Maker Name to check cost >>");
		String make = input.nextLine();
		make = input.nextLine();
		
		System.out.println("--------------------------");
		for(Booking bkg:bk) //enhanced for loop
		{
			if(bkg.getName().equals(make))
				bkg.PrintBooking(); // printing booking info of the vehicle
		}
		System.out.println("--------------------------");
		
		UpdateVehicleInfo(make); // a mathod  that update the vehicle method
		
		for(Vehicle ve:Vh) //get vehicle info in details
		{
			System.out.println("Regestration No. : "+ve.getRegistrationNumber());
			System.out.println("Car Maker        : "+ve.getMake());
			System.out.println("Car Model        : "+ve.getModel());
			int d = CountBooking(ve.getMake());
			System.out.println("Number of Booking: "+d);
			UpdateVehicleInfo(ve.getMake());
			System.out.println();
		}
		
		
		DeleteBooking();
		
		UpdateBooking();
		
		System.out.println("<< Enter any department name to print in details >>");
		String depName = input.nextLine();
		
		DepartmentInfoPrint(depName);
		
		
		
	}
	
	public void DepartmentInfoPrint(String depName) // a mathod that print info based on the department
 	{
		System.out.println("-------------------------------------");
		for(Booking bkg:bk)
		{
			if(bkg.getDeptName().equals(depName))
			{
				bkg.PrintBooking();
			}
		}
		System.out.println("-------------------------------------");
	}
	
	public void UpdateBooking() // a mathod that help to change or update the booking data
	{
		
		System.out.println("<< Do you want to update the booking >> ");
		System.out.println("Press 1 >> Yes");
		System.out.println("Press 2 >> No");
		int op = input.nextInt();
		
		System.out.println("-------------------------------------");
		for(Booking bkg:bk)
		{
			bkg.PrintBooking();
		}
		System.out.println("-------------------------------------");
		
		System.out.println("<< Enter the department Name >>");
		String name = input.nextLine();
		name = input.nextLine();
		
		
		for(Booking bkg:bk)
		{
			if(bkg.getDeptName().equals(name))
			{
				System.out.println("<< Enter new Starting Date >>");
				bkg.setDateFrom(input.nextLine());
				System.out.println("<< Enter new Ending Date >>");
				bkg.setDateTo(input.nextLine());
			}
		}
		System.out.println("-------------------------------------");
		for(Booking bkg:bk)
		{
			if(bkg.getDeptName().equals(name))
			{
				bkg.PrintBooking();
			}
		}
		System.out.println("-------------------------------------");
		
	}
	
	public void DeleteBooking() // a mathod that delete a data based on the department name
	{
		System.out.println("<< Do you want to delete any booking >>");
		System.out.println("press 1 >> yes");
		System.out.println("Press 2 >> No");
		int op = input.nextInt();
		
		if(op == 1)
		{
			System.out.println("-------------------------------------");
			for(Booking bkg:bk)
			{
				bkg.PrintBooking();
			}
			System.out.println("-------------------------------------");
			
			System.out.println("<< Enter the department Name >>");
			String name = input.nextLine();
			name = input.nextLine();
			
			int s=0;
			for(Booking bkg:bk)
			{
				if(bkg.getDeptName().equals(name))
				{
					break;
				}
				s++;
			}
			bk.remove(s); //remove the data
			
			System.out.println("-------------------------------------");
			for(Booking bkg : bk)
			{
				bkg.PrintBooking();
			}
			System.out.println("-------------------------------------");
			
		}
		else if(op == 2)
		{
			
		}
		else 
			System.out.println("Invalid Option");
	}
	
	public void UpdateVehicleInfo(String make) // a mathod that update only the vehicle related information
	{
		String[] info = new String[1000];
		int count =0,x;
		double sum=0;
		String key = null;	
		
		try
		{
			File f = new File("Days.txt"); // used a file from where the data are gained 
			Scanner input = new Scanner(f);
			
			for(int i=0;input.hasNextLine();i++)
			{
				info[i] = input.nextLine();
				count++;
			}			
					
			for(int i=0;i<count;i=i+2)
			{
				for(int j=0;j<cr.size();j++)//carefully finding out the the days and finding out the cost
				{
					if(info[i].equals(make) && make.equals(cr.get(j).getMake()))
					{
						x = Integer.parseInt(info[i+1]);
						cr.get(j).setTotalDays(x);
						sum = sum + cr.get(j).usageCost();
					}
				}
			}
		
			for(int i=0;i<count;i=i+2)
			{
				for(Van van:vn)
				{
					if(info[i].equals(make) && van.getMake().equals(make))
					{
						x = Integer.parseInt(info[i+1]);
						van.setTotalDays(x);
						sum = sum + van.usageCost();
					}
				}
			}
			
			
			System.out.println("Total cost of " + make + " is " + sum);
			System.out.println("---------------------------------------");
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

	public int CountBooking(String vhMake) // a method that count the total booking of each vehicle
	{
		String[] info = new String[1000]; // an array that temporaryly hold data for further process
		int count = 0,x=0;
		try
		{
			File f = new File("VehicleInfo.txt"); //the fill is readed
			Scanner input = new Scanner(f);
			for(int i=0;input.hasNextLine();i++)
			{
				info[i] = input.nextLine();
				count++;
			}
			
			for(int i=0;i<count;i++)
			{
				if(info[i].equals(vhMake))
					x++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		return x; //returning the total booking of each vehicle
	}
	
	public void DataEntryToList()
	{
		String[] info = new String[1000]; 
		String x[] = new String[1000];
		String y[] = new String[1000];   // 5 temporary array used to process the data ,
		String z[] = new String[1000];	// these are temporary array
		String n[] = new String[1000];
		
		Booking bg;
		
		int count=0;

		try
		{
			File f = new File("VehicleInfo.txt"); //4 kind of information is in this file 
			Scanner input = new Scanner(f);   // the processing process is implemented based on this idea
			
			for(int i=0;input.hasNextLine();i++)
			{
				info[i] = input.nextLine();
				count++;
			}
			
			//System.out.println(count);
			
			int a=0;
			for(int i=1;i<count;i=i+4)
			{
				x[a] = info[i];
				//System.out.println(x[a]);
				a++;
			}
			a=0;
			for(int i=0;i<count;i=i+4)
			{
				n[a] = info[i];
				a++;
			}
			
			a=0;
			for(int i=2;i<count;i=i+4)
			{
				y[a] = info[i];
				//System.out.println(info[i]);
				a++;
			}
			a=0;
			for(int i=3;i<count;i=i+4)
			{
				z[a] = info[i];
				//System.out.println(info[i]);
				a++;
			}
			
			for(int i=0;i<a;i++)
			{
				bg = new Booking(x[i],y[i],z[i]);
				bg.setName(n[i]);
				bk.add(i, bg);
			}
		}
		catch(Exception f){
			System.out.println(f.toString());
		}
	}
}
