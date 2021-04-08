package statsVisualiser.gui;

public class HspBeds {
	
	double[] HospitalBeds; 
	String[] Viewers; 
	int NoYears; 
	int[] Years;
	
	
	public HspBeds(double[] beds, String[] views, int numberOfYears, int[] years )
	{
		this.HospitalBeds = beds;
		this.Viewers = views;
		this.NoYears = numberOfYears;
		this.Years = years;
	}
	
	public void Display()
	{
		for(int i=0; i<this.Viewers.length; i++)
		{
			if(Viewers[i].equals("Pie Chart"))
			{
				System.out.println("HspBeds Pie Chart will be displayed");
			}
			else if(Viewers[i].equals("Line Graph"))
			{
				System.out.println("HspBeds Line Graph will be displayed");
//				Line lineGraph = new Line();
//				lineGraph.create(this);
//				System.out.println("Forest Line Graph will be displayed");
			}
			else if(Viewers[i].equals("Bar Graph"))
			{
				System.out.println("HspBeds Bar Graph will be displayed");
			}
			else if(Viewers[i].equals("Scatter Plot"))
			{
				System.out.println("HspBeds Scatter Plot will be displayed");
			}
			else if(Viewers[i].equals("Report"))
			{
				System.out.println("HspBeds Report will be displayed");
			}
		}
	}

}
