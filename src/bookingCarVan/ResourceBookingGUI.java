package bookingCarVan;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * 
 * this class is designed to represent the value using graphical interface
 * 
 */

public class ResourceBookingGUI implements ActionListener
{
	List<Vehicle> Vh = new ArrayList<>(); //some lists of vehicle type, car type, van ,booking type 
	List<Car> cr = new ArrayList<>();
	List<Van> vn = new ArrayList<>();
	List<Booking> bk = new ArrayList<>();
	int ttlVehicle; //count the total vehicle 
	int ttlBooking; // count the total booking of each vehicle
	
	JButton save = new JButton("Save"); 
	JButton load = new JButton("Load");
	
	public ResourceBookingGUI(List<Vehicle> v,List<Car> c,List<Van> vn,int ttlVehicle){
		Vh = v;
		cr = c;
		this.vn = vn;
		this.bk = bk;
		this.ttlVehicle = ttlVehicle;
	}
	
	public void VehicleDetails() // a method that display the vehicle information
	{
		JFrame window = new JFrame();
		GridLayout gl = new GridLayout(20,1,5,5); // finalizing the window size
		window.setLayout(gl);
		
		//System.out.println(ttlVehicle);
		JLabel jbR[] = new JLabel[ttlVehicle];
		JLabel jbMk[] = new JLabel[ttlVehicle];
		JLabel jbMd[] = new JLabel[ttlVehicle];
		
	
		int i=0;
		for(Vehicle v:Vh) // printing all the elements in list formate
		{
			jbR[i] = new JLabel(" Regestration No.  " + "    ::  " + v.getRegistrationNumber());
			jbMk[i] = new JLabel(" Make Company              ::  " + v.getMake());
			jbMd[i] = new JLabel(" Model No                  ::  " + v.getModel());
			window.add(jbR[i]);
			window.add(jbMk[i]);
			window.add(jbMd[i]);
			i++;
		}
		
		window.setTitle("Vehicle Detail List");
		window.setSize(450 ,500);
		window.setLocation(280, 80);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setVisible(true);
	}
	
	public void OneVehicleBooking(String make) // a method that diplay a particular vehicle booking
	{
		JFrame window = new JFrame();
		GridLayout gl = new GridLayout(20,2,5,5);
		window.setLayout(gl);
		
		DataEntryToList();
	
		JLabel jbD[] = new JLabel[ttlBooking];
		JLabel jbFD[] = new JLabel[ttlBooking];
		JLabel jbTD[] = new JLabel[ttlBooking];
		
		int i=0;
		for(Booking bkg:bk)
		{
			if(bkg.getName().equals(make)) // printing in a list formate
			{
				JLabel j = new JLabel(" Car Name          :: " + bkg.getName());
				window.add(j);
				jbD[i] = new JLabel(" Department Name    :: " + bkg.getDeptName() );
				window.add(jbD[i]);
				jbFD[i] = new JLabel(" Starting Date       :: " + bkg.getDateFrom() );
				window.add(jbFD[i]);
				jbTD[i] = new JLabel(" Ending Date         :: " + bkg.getDateTo() );
				window.add(jbTD[i]);
			}
			i++;
		}
		
		window.setTitle("One Vehicle Booking List");
		window.setSize(300 ,600);
		window.setLocation(280, 80);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setVisible(true);
	}
	
	public void SpecificDepBooking(String dep) //a method display information based on the department 
	{
		JFrame window = new JFrame();
		GridLayout gl = new GridLayout(20,2,5,5);
		window.setLayout(gl);
		
		DataEntryToList(); // booking data is entered to the list by this method
	
		JLabel jbD[] = new JLabel[ttlBooking];
		JLabel jbFD[] = new JLabel[ttlBooking]; // declaring jlabel as an array
		JLabel jbTD[] = new JLabel[ttlBooking];
				
		int i=0;
		for(Booking bkg:bk)
		{
			if(bkg.getDeptName().equals(dep)) // printing in a list formate
			{
				jbD[i] = new JLabel(" Department Name    :: " + bkg.getDeptName() );
				window.add(jbD[i]);
				jbFD[i] = new JLabel(" Starting Date       :: " + bkg.getDateFrom() );
				window.add(jbFD[i]);
				jbTD[i] = new JLabel(" Ending Date         :: " + bkg.getDateTo() );
				window.add(jbTD[i]);
				i++;
			}
		}
		
		window.setTitle("Vehicle Booking based on deparment List");
		window.setSize(300 ,600);
		window.setLocation(280, 80);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setVisible(true);
	}
	
	public void SaveVehicleInfo() //a method that save the vehicle information to the file
	{
		JFrame window = new JFrame();
		GridLayout gl = new GridLayout(20,2,5,5);
		window.setLayout(gl);
		
		//System.out.println(ttlVehicle);
		JLabel jbR[] = new JLabel[ttlVehicle];
		JLabel jbMk[] = new JLabel[ttlVehicle];
		JLabel jbMd[] = new JLabel[ttlVehicle];	
	
		int i=0;
		for(Vehicle v:Vh) //printing in alist formate
		{
			jbR[i] = new JLabel(" Regestration No.  " + "    ::  " + v.getRegistrationNumber());
			jbMk[i] = new JLabel(" Make Company              ::  " + v.getMake());
			jbMd[i] = new JLabel(" Model No                  ::  " + v.getModel());
			window.add(jbR[i]);
			window.add(jbMk[i]);
			window.add(jbMd[i]);
			i++;
		}
		
		window.add(save);
		
		window.setTitle("Vehicle Detail List");
		window.setSize(450 ,600);
		window.setLocation(280, 80);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		save.addActionListener(this);
		
		window.setVisible(true);
	}
	
	public void LoadDataFromFile() //loading the date from the file and printing to the console
	{
		JFrame window = new JFrame();
		GridLayout gl = new GridLayout(6,1,1,1);
		window.setLayout(gl);
		
		JLabel j = new JLabel("                                Press the Button");
		JLabel js = new JLabel("                             Vehicle info will load");
		
		
		window.add(j);
		window.add(js);
		window.add(load);
		
		window.setTitle("Vehicle Detail List");
		window.setSize(300 ,350);
		window.setLocation(280, 80);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		load.addActionListener(this);
		
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == save)
		{
			try
			{
				FileWriter fw = new FileWriter("DetailsOFVehicle.txt",false);
				for(Vehicle vc:Vh)
				{
					fw.write(vc.getRegistrationNumber());
					fw.write("\r\n");
					fw.write(vc.getMake());
					fw.write("\r\n");
					fw.write(vc.getModel());
					fw.write("\r\n");
					
				}
				fw.close();
			}	
			catch(Exception c)
			{
				System.out.println(c.toString());
			}
		}
		
		else if(e.getSource() == load)
		{
			try
			{
				File f = new File("DetailsOfVehicle.txt");
				Scanner input = new Scanner(f);
				
				while(input.hasNextLine())
				{
					System.out.println(input.nextLine());
				}
			}
			catch(Exception z)
			{
				System.out.println(z.toString());
			}
		}
	}
	
	public void DataEntryToList() // a method that works to entry the data to the lists
	{
		String[] info = new String[1000];
		String x[] = new String[1000];
		String y[] = new String[1000];  // some temporary arrays those help to process the data
		String z[] = new String[1000];
		String n[] = new String[1000];
		
		Booking bg;
		
		int count=0;

		try
		{
			File f = new File("VehicleInfo.txt");
			Scanner input = new Scanner(f);
			
			for(int i=0;input.hasNextLine();i++)
			{
				info[i] = input.nextLine();
				count++;
			}
			
			//System.out.println(count);
			ttlBooking = count;
			
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
