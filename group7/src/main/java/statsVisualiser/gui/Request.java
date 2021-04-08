package statsVisualiser.gui;


/**
 * Request class that takes all of the selected data from the User in the UI and stores it
 * @author Kashawn Brown
 */
public class Request {
	
	//Instance variables of each selection made by user
	private String Country;
	private int Type_Of_Request;
	private String DataTypes[];
	private int SYear, EYear;
	private String Viewers[];
	
	/**
	 * Constructor of the class to set all the instance variables with the info provided by user
	 * @param C		Country provided
	 * @param T		Type of analysis chosen
	 * @param D		Data types needed for chosen analysis
	 * @param SY	Start year of analysis
	 * @param EY	End year of analysis
	 * @param V		Viewers selected to be displayed
	 */
	public Request(String C, int T, String[] D, int SY, int EY, String[] V)
	{
		this.Country = C;
		this.Type_Of_Request = T;
		this.DataTypes = D;
		this.SYear = SY;
		this.EYear = EY;
		this.Viewers = V;
		
//		RequestHandler handle = new RequestHandler();
//		handle.FetchData(this);
//		handle.SendData();
	}
	
	//Setter methods to reset information
	public void SetCountry(String C)
	{
		this.Country = C;
	}
	public void SetRequest(int T) 
	{
		this.Type_Of_Request = T;
	}
	public void DataTypes(String[] D) 
	{
		this.DataTypes = D;
	}
	public void SetStartYear(int SY)
	{
		this.SYear = SY;
	}
	public void SetEndYear(int EY)
	{
		this.EYear = EY;
	}
	public void SetViewers(String[] V) 
	{
		this.Viewers = V;
	}
	
	//Getter methods to get information chosen
	public String GetCountry()
	{
		return this.Country;
	}
	public int GetRequest() 
	{
		return this.Type_Of_Request;
	}
	public String[] GetDataTypes() 
	{
		return this.DataTypes;
	}
	public int GetStartYear()
	{
		return this.SYear;
	}
	public int GetEndYear()
	{
		return this.EYear;
	}
	public String[] GetViewers() 
	{
		return this.Viewers;
	}
	
	/**
	 * Add a viewer to the list of viewers selected
	 * @param view Viewer to be added
	 */
	public void AddViewer(String view)
	{
		//variable to see if it is a new viewer, or one already in the list
		boolean newView = true;
		
		//CHecks current list of viewers to see if it is a new viewer or already listed
		for(int i=0; i<Viewers.length; i++)
		{
			if(Viewers[i].equals(view))
			{
				newView = false;
			}
		}
		
		//If it is a new view that wants to be added
		//Makes temporary viewer list to store all current viewers plus the new one, then makes list of Viewers array 1 larger than before and sets it to the temporary list
		if(newView)
		{
			String[] tempViews = new String[Viewers.length + 1];
			for(int j=0; j<Viewers.length; j++)
			{
				tempViews[j] = Viewers[j];
			}
			tempViews[Viewers.length] = view;
			this.Viewers = new String[tempViews.length];
			this.Viewers = tempViews;
			
		}
	}
	
	/**
	 * Remove a viewer from the list of viewers selected
	 * @param view Viewer to be removed
	 */
	public void RemoveViewer(String view)
	{
		//variable for if the view is currently in the list or not
		boolean currentView = false;
		
		//If found in list of viewers boolean variable set to true, that place in the list is replaced with null, and loop ends
		for(int i=0; i<Viewers.length; i++)
		{
			if(Viewers[i].equals(view))
			{
				Viewers[i] = null;
				currentView = true;
				break;
			}
		}
		
		
		
		//If the viewer to be removed was found in the list
		if(currentView)
		{
			//Checks if null is in the list of viewers, meaning if it is, then a viewer was removed
			//Reorganizes so that the removed viewer is set to the end of the array and all viewers that may have came after it are moved up
			for(int i=0; i<Viewers.length; i++)
			{
				if(Viewers[i] == null & i != Viewers.length-1)
				{
					String temp = Viewers[i];
					Viewers[i] = Viewers[i+1];
					Viewers[i+1] = temp;
				}
			}
			
			//Makes temporary viewer list to store all current viewers except the null one at the end that was removed
			//Then remakes list of Viewers array 1 smaller than before and sets it to the temporary list
			String[] tempViews = new String[Viewers.length - 1];
			for(int j=0; j<Viewers.length-1; j++)
			{
				tempViews[j] = Viewers[j];
			}
			this.Viewers = new String[tempViews.length];
			this.Viewers = tempViews;
			
		}
	}

}
