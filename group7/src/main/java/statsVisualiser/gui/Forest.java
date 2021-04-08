package statsVisualiser.gui;

public class Forest {
	
	double[] LandPercentage; 
	String[] Viewers; 
	int NoYears; 
	int[] Years;
	
	public Forest(double[] percent, String[] views, int numberOfYears, int[] years)
	{
		this.LandPercentage = percent;
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
				System.out.println("Forest Pie Chart will be displayed");
			}
			else if(Viewers[i].equals("Line Graph"))
			{
				System.out.println("Forest Line Graph will be displayed");
//				Line lineGraph = new Line();
//				lineGraph.create(this);
//				System.out.println("Forest Line Graph will be displayed");
			}
			else if(Viewers[i].equals("Bar Graph"))
			{
				System.out.println("Forest Bar Graph will be displayed");
			}
			else if(Viewers[i].equals("Scatter Plot"))
			{
				System.out.println("Forest Scatter Plot will be displayed");
			}
			else if(Viewers[i].equals("Report"))
			{
				System.out.println("Forest Report will be displayed");
			}
		}
	}




}
