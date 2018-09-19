package bookingCarVan;

import java.io.File;

import java.util.*;
import java.io.*;
import java.util.*;

public class Main 
{
	static List<Car> cr = new ArrayList<>(); // some static variable cr and vn acts like globally
	static List<Van> vn = new ArrayList<>();
	static int ttlVehicle;
	
	public static void main(String[] args) 
	{
		Scanner Input = new Scanner(System.in);
		List<Vehicle> Vh = new ArrayList<>();
		String reg,mk,mdl;
		
		int op;
		
		try
		{
			File f = new File("welcome.txt"); // this file helps to print welcome design
			Scanner input = new Scanner(f);
			
			while(input.hasNextLine())
			{
				System.out.println(input.nextLine());
			}
							
		}
		catch(Exception f)
		{
			System.out.println(f.toString());
		}
		
		System.out.println("<< Which vehicle you want to add >>");
		System.out.println("Press 1 >> Car");
		System.out.println("Press 2 >> Van");
		op = Input.nextInt();
		
		if(op == 1)
		{
			try
			{
				FileWriter fw = new FileWriter("Cars.txt",true); // file writting to save the permanently
				System.out.println("<< Enter the regestration number >>");
				reg = Input.nextLine();
				reg = Input.nextLine();
				fw.write(reg);
				fw.write("\r\n");
				
				System.out.println("<< Enter the Car Maker >>");
				mk = Input.nextLine();
				fw.write(mk);
				fw.write("\r\n");
				
				System.out.println("<< Enter the model number >>");
				mdl = Input.nextLine();
				fw.write(mdl);
				fw.write("\r\n");
				
				fw.close();
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
			
		}
		else if(op == 2)
		{
			try
			{
				FileWriter fw = new FileWriter("Vans.txt",true);
				System.out.println("<< Enter the regestration number >>");
				reg = Input.nextLine();
				reg = Input.nextLine();
				fw.write(reg);
				fw.write("\r\n");
				
				System.out.println("<< Enter the Car Maker >>");
				mk = Input.nextLine();
				fw.write(mk);
				fw.write("\r\n");
				
				System.out.println("<< Enter the model number >>");
				mdl = Input.nextLine();
				fw.write(mdl);
				fw.write("\r\n");
				
				fw.close();
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		Vh = DataEntryToList(); // calling the data entry method
		
		
		ResourceBookingConsole rbc = new ResourceBookingConsole(); //creating for the console application
		company cm = new company("BRS Vehicle Booking@Cor.");  // company name
		
		rbc.BookingConsole(Vh,cr,vn,cm);
		
		System.out.println("<< Now GUI Application is start up>>");
		ResourceBookingGUI rbg = new ResourceBookingGUI(Vh,cr,vn,ttlVehicle);
		rbg.VehicleDetails();
		
		System.out.println("<< Enter any Vehicle Maker Name >>");
		String make = Input.nextLine();
		rbg.OneVehicleBooking(make);
		
		System.out.println("<< Enter any Department Name >>");
		String dep = Input.nextLine();
		rbg.SpecificDepBooking(dep);
		
		System.out.println("<< Press the save button to save the data >>");
		rbg.SaveVehicleInfo();
		
		System.out.println("<< press the load button to load the data >>");
		rbg.LoadDataFromFile();
	}
	
	public static List<Vehicle> DataEntryToList() // data entry to the list
	{
		List<Vehicle> Vh = new ArrayList<>();
		
		String[] infoC = new String[1000];
		String xC[] = new String[1000];
		String yC[] = new String[1000];
		String zC[] = new String[1000];
		
		String[] infoV = new String[1000];
		String xV[] = new String[1000];
		String yV[] = new String[1000];
		String zV[] = new String[1000];
		
		Car c;
		Van v;
		
		int countc=0,countv=0,ttl=0;

		try
		{
			File fc = new File("Cars.txt");
			File fv = new File("Vans.txt");
			Scanner inputc = new Scanner(fc);
			Scanner inputv = new Scanner(fv);
			
			for(int i=0;inputc.hasNextLine();i++)
			{
				infoC[i] = inputc.nextLine();
				countc++;
			}
			
			for(int i=0;inputv.hasNextLine();i++)
			{
				infoV[i] = inputv.nextLine();
				countv++;
			}
			
			ttl = (countc/3) + (countv/3);
			//System.out.println(ttl);
			ttlVehicle = countc + countv;
			
			int a=0;
			for(int i=0;i<countc;i=i+3)
			{
				xC[a] = infoC[i];
				//System.out.println(xC[a]);
				a++;
			}
			
			int aV=0;
			for(int i=0;i<countv;i=i+3)
			{
				xV[aV] = infoV[i];
				//System.out.println(xV[a]);
				aV++;
			}
			a=0;
			for(int i=1;i<countc;i=i+3)
			{
				yC[a] = infoC[i];
				//System.out.println(infoC[i]);
				a++;
			}
			
			aV=0;
			for(int i=1;i<countv;i=i+3)
			{
				yV[aV] = infoV[i];
				//System.out.println(infoV[i]);
				aV++;
			}
			
			a=0;
			for(int i=2;i<countc;i=i+3)
			{
				zC[a] = infoC[i];
				//System.out.println(infoC[i]);
				a++;
			}
			
			aV=0;
			for(int i=2;i<countv;i=i+3)
			{
				zV[aV] = infoV[i];
				//System.out.println(infoV[i]);
				aV++;
			}
			
			for(int i=0;i<a;i++)
			{
				//System.out.println(i);
				c = new Car(xC[i],yC[i],zC[i]);
				cr.add(i,c);
				Vh.add(i,c);
			}
			int temp = a;

			for(int i=0;i<aV;i++)
			{
				v = new Van(xV[i],yV[i],zV[i]);
				vn.add(i,v); 
				Vh.add(temp, v);
				temp++;
			}
		}
		catch(Exception f){
			System.out.println(f.toString());
		}
		
		return Vh;
	}

}
