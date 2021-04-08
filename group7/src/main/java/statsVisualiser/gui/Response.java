package statsVisualiser.gui;

/**
 * Class to start formulating a response to the request made by user with all the information provided, now with the data retrieved from the world Bank repository
 * @author Kashawn Brown
 *
 */
public class Response {
	
	int Type_Of_Request;
	String Viewers[];
	double [][] Data;
	int Years[];
	int NoYears;

		
	/**
	 * Organize method to break down the data provided accordingly based on the type of request that was made, then makes a call to the correct request class so that the data can then be properly handled for display
	 * @param handler Object of the Request Handler class where all necessary data was fetched and stored 
	 */
	public void Organize(RequestHandler handler)
	{
		this.Type_Of_Request = handler.Type_Of_Request;
		this.Viewers = handler.Viewers;
		this.Data = handler.Data;
		this.Years = handler.Years;
		this.NoYears = handler.NoYears;
		
		//Kashawn Brown - Forest Area
		if(Type_Of_Request == 1)
		{
			
			double[] percentage = new double[NoYears];
			percentage = Data[0];
			
			Forest requestForest =  new Forest(percentage, Viewers, NoYears, Years);
			requestForest.Display();
			
		}
		
		//Kashawn Brown - Population vs CO2
		else if(Type_Of_Request == 2)
		{
			
			int[] pop = new int[NoYears];
			
			
			for(int i=0; i<NoYears; i++)
			{
				pop[i] = (int) Data[0][i];
			}
			double[] emissions = new double[NoYears];
			emissions = Data[1];
			
			POPvCO2 requestPvC = new POPvCO2(pop, emissions, Viewers, NoYears, Years);
			requestPvC.Display();
			
		}
		
		//Paul - Hospital Beds
		else if(Type_Of_Request == 3)
		{
			
			double[] beds  = new double[NoYears];
			beds = Data[0];
			
			HspBeds hospital = new HspBeds(beds, Viewers, NoYears, Years);
			hospital.Display();
			
		}
		
		//Paul - GDP
		else if(Type_Of_Request == 4)
		{
			
			double[] GDP = new double[NoYears];
			GDP = Data[0];
			
			GDP G = new GDP(GDP, Viewers, NoYears, Years);
			G.Display();
		}
		
		else if(Type_Of_Request == 5)
		{
			//Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP).
			//Government expenditure on education, total (% of GDP) SE.XPD.TOTL.GD.ZS
			//Current health expenditure per capita (current US$) SH.XPD.CHEX.PC.CD
			double[] Education = new double[NoYears];
			double[] Health = new double[NoYears];
			
			EDUCATIONvHEALTH G = new EDUCATIONvHEALTH(Education, Health, Viewers, NoYears, Years);
			G.Display();
		}
		
		else if(Type_Of_Request == 6)
		{
			//PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area) (2-series graphs)
			//PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) EN.ATM.PM25.MC.M3\
			//Forest area (% of land area) AG.LND.FRST.ZS
			double[] Pollution = new double[NoYears];
			double[] LandPercentage = new double[NoYears];
			
			POLLUTIONvFOREST G = new POLLUTIONvFOREST(Pollution, LandPercentage, Viewers, NoYears, Years);
			G.Display();
		}
		
		else if(Type_Of_Request == 7)
		{
			//Current health expenditure (% of GDP) vs Current health expenditure per capita (current US$)
			//Current health expenditure (% of GDP) SH.XPD.CHEX.GD.ZS
			//Current health expenditure per capita (current US$) SH.XPD.CHEX.PC.CD
			double[] Capita = new double[NoYears];
			
			HealthExpenditure G = new HealthExpenditure(Capita, Viewers, NoYears, Years);
			G.Display();
		}
		
		else if(Type_Of_Request == 8)
		{
			//Forest area (% of land area) vs Energy use (kg of oil equivalent per capita)
			//Forest area (% of land area) AG.LND.FRST.ZS
			//Energy use (kg of oil equivalent per capita) EG.USE.PCAP.KG.OE
			double[] LandPercentage = new double[NoYears];
			double[] Energy = new double[NoYears];
			
			ForestAREAvENERGYUse G = new ForestAREAvENERGYUse(LandPercentage, Energy, Viewers, NoYears, Years);
			G.Display();
		}
		
	}
	
	
	
	
	
}
