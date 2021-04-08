package statsVisualiser.gui;


public class Viewers {

	String[]  Viewers;
	private static Viewers  Instance = null;
	
	public Viewers()
	{
		Viewers = new String[0];
	}
	
	
	public static Viewers getInstance()
	{
		if(Instance == null)
		{
			Instance = new Viewers();
		}
		return Instance;
	}
	
	public static void newList()
	{
		Instance = new Viewers();
	}
	
	public String[] GetViewers()
	{
		return Viewers;
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
