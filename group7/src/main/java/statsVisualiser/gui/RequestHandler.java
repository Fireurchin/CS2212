package statsVisualiser.gui;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

/**
 * Request Handler class that takes the information from the requests of the user and gets the required data for the analysis from the World Bank repository
 * @author Kashawn Brown
 *
 */
public class RequestHandler {

	//Instance variables of the class further breaking down the information that was provided to then make the proper anaylysis
	String Country; 				//Country chosen by User
	int Type_Of_Request; 			//Type of Request (1-8) indexing the 8 possible types of analysis and which one was chosen by the User
	String DataTypes[];				//Listing the data types needed for the particular analysis, whether one, two, or three series data, that particular number of datatupes are required
	String URL[];					//Array for the URLS required as for each datatype needed for the analysis, the appropriate URL must then be used to fetch that data 
	int SYear, EYear, NoYears; 		//Start and end year for analysis chosen by user, as well as computed number of years for the analysis
	String Viewers[];				//Array of the all the different viewers the user has chosen to want to have displayed
	int Years[];					//Array containing each year of the analysis
	double Data[][];				//2D array to store the values of the data needed. If 1 series the data for the required years will be stored in Data[0]
										//If 2-series the 1st data values will be stored in array of Data[0], the 2nd data values will be stored in array of Data[1]
										//If 3-series the 1st data values will be stored in array of Data[0], the 2nd data values will be stored in array of Data[1], the 3rd data values will be stored in array of Data[2]
										//Essentially Data[Datatype Index][Year Index]
			
	/**
	 * Method to go fetch all the required data based on the information provided by user for the analysis chosen 
	 * @param info Object of the Request class storing all the information provided by User to be broken down and used to fetch data
	 */
	public void FetchData(Request info)
	{
		//Setting all the appropriate instance variables of the class based on the information taken from requests of user
		this.Country = info.GetCountry();
		this.Type_Of_Request = info.GetRequest();
		this.DataTypes = info.GetDataTypes();
		this.SYear = info.GetStartYear();
		this.EYear = info.GetEndYear();
		this.NoYears = EYear - SYear + 1;
		this.Viewers = info.GetViewers();
		this.Data = new double[DataTypes.length][NoYears];
		this.URL = new String[DataTypes.length];
		this.Years = new int[NoYears];
		
		//Loop to fetch the values for each data type needed for the analysis chosen
		for(int i=0; i<DataTypes.length; i++)
		{
			URL[i] = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%d:%d&format=json", Country, DataTypes[i], SYear, EYear);
			double data;		//local data variable to store the value of each data type before being added to the 2D array
			try {
				//local url variable to use the string url formed for each datatype needed
				//URL is opened and all necessary info is fetched regarding the data
				URL url = new URL(URL[i]);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				int responsecode = conn.getResponseCode();
				if (responsecode == 200) 
				{
					String inline = "";
					Scanner sc = new Scanner(url.openStream());
					while (sc.hasNext()) 
					{
						inline += sc.nextLine();
					}
					sc.close();
					JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
					int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
					int year;
					for (int j = 0; j < sizeOfResults; j++) 
					{
						year = jsonArray.get(1).getAsJsonArray().get(j).getAsJsonObject().get("date").getAsInt();
						//years stored in years array
						Years[j] = year;
						
						if (jsonArray.get(1).getAsJsonArray().get(j).getAsJsonObject().get("value").isJsonNull())
							data = 0;
						else
							data = jsonArray.get(1).getAsJsonArray().get(j).getAsJsonObject().get("value").getAsDouble();
						//values of data stored in 2D array using format explained before
						Data[i][j] = data;
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block e.printStackTrace();
			}

		}
		//possible to just send data directly after formatting it all, instead of having a separated method for it
//		Response respond = new Response();
//		respond.Organize(this);

		
		
	}
	
	/**
	 * Creates an instance of the respond class and sends as input to its Organize method this class with all of the required updated information
	 */
	public void SendData()
	{
		Response respond = new Response();
		respond.Organize(this);
	}
}
