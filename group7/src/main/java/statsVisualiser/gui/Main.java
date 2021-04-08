package statsVisualiser.gui;
import java.util.Scanner; 

/** Main class just to test
 * @author Kashawn Brown
 */
public class Main {


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String[] data = null;
		String country, in;
		int type, syear, eyear;
		
		System.out.println("input the country to do analyzation");
		country = scan.next();
		System.out.println("input type of analyzation");
		type = scan.nextInt();
		System.out.println("input start year for analyzation");
		syear = scan.nextInt();
		System.out.println("input end year for analyzation");
		eyear = scan.nextInt();
		
		if(type == 1)
		{
			String[] dat = {"AG.LND.FRST.ZS"};
			data = dat;
		}
		else if(type == 2)
		{
			String[] dat = {"SP.POP.TOTL", "EN.ATM.CO2E.PC"};
			data = dat;
		}
		else if(type == 3)
		{
			String[] dat = {"SH.MED.BEDS.ZS"};
			data = dat;
		}
		else if(type == 4)
		{
			String[] dat = {"NY.GDP.PCAP.CD"};
			data = dat;
		}
		else if(type == 5)
		{
			//Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP).
			//Government expenditure on education, total (% of GDP) SE.XPD.TOTL.GD.ZS
			//Current health expenditure per capita (% of GDP) SH.XPD.CHEX.GD.ZS
			String[] dat = {"SE.XPD.TOTL.GD.ZS", "SH.XPD.CHEX.GD.ZS"};
			data = dat;
		}
		else if(type == 6)
		{
			//PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area) (2-series graphs)
			//PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) EN.ATM.PM25.MC.M3
			//Forest area (% of land area) AG.LND.FRST.ZS
			String[] dat = {"EN.ATM.PM25.MC.M3", "AG.LND.FRST.ZS"};
			data = dat;
		}
		else if(type == 7)
		{
			//Current health expenditure per capita (current US$) SH.XPD.CHEX.PC.CD
			String[] dat = {"SH.XPD.CHEX.PC.CD"};
			data = dat;
		}
		else if(type == 8)
		{
			//Forest area (% of land area) vs Energy use (kg of oil equivalent per capita)
			//Forest area (% of land area) AG.LND.FRST.ZS
			//Energy use (kg of oil equivalent per capita) EG.USE.PCAP.KG.OE
			String[] dat = {"AG.LND.FRST.ZS", "EG.USE.PCAP.KG.OE"};
			data = dat;
		}
		else 
		{
			String[] dat = {"SP.POP.TOTL"};
			data = dat;
		}
		
		 

		//String[] charts = {"Pie Chart", "Line Graph", "Bar Graph"};
		
		
		Viewers view = Viewers.getInstance();
		
		
//		Viewers test = Viewers.getInstance();
//		Viewers.newList();
//		test = Viewers.getInstance();
		
		
		
		System.out.println("input a Chart you would like to have displayed");
		in = scan.nextLine();
		while(!in.equals("end"))
		{
			if(in.equals("Bar Graph"))
			{
				view.AddViewer("Bar Graph");
				System.out.println("input another Chart you would like to have displayed");
				in = scan.nextLine();
			}
			else if(in.equals("Line Graph"))
			{
				view.AddViewer("Line Graph");
				System.out.println("input another Chart you would like to have displayed");
				in = scan.nextLine();
			}
			else if(in.equals("Pie Chart"))
			{
				view.AddViewer("Pie Chart");
				System.out.println("input another Chart you would like to have displayed");
				in = scan.nextLine();
			}
			else if(in.equals("Scatter Plot"))
			{
				view.AddViewer("Scatter Plot");
				System.out.println("input another Chart you would like to have displayed");
				in = scan.nextLine();
			}
			else if(in.equals("Report"))
			{
				view.AddViewer("Report");
				System.out.println("input another Chart you would like to have displayed");
				in = scan.nextLine();
			}
			else
			{
				System.out.println("Invalid Choice. Input another Chart you would like to have displayed");
				in = scan.nextLine();
			}
		}
		
		String[] list = view.GetViewers();
		
		Request initiation = new Request(country, type, data, syear, eyear, list);
		

		
//		System.out.println(initiation.GetCountry());
//		System.out.println(initiation.GetEndYear());
//		System.out.println(initiation.GetRequest());
//		System.out.println(initiation.GetStartYear());
//		String[] data = initiation.GetDataTypes();
//		System.out.println(data[0] + "\n" + data[1]);
//		String[] data2 = initiation.GetViewers();
//		System.out.println(data2[0] + "\n" + data2[1] + "\n" + data2[2] + "\n" + data2[3]);
		
		RequestHandler handle = new RequestHandler();
		handle.FetchData(initiation);
		handle.SendData();
		
		CountryList countries = new CountryList("country_list.csv");
		
		System.out.println(countries.size());
		
		
	}

	
}
