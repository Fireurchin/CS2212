package statsVisualiser.gui;

public class ForestAREAvENERGYUse {
	
	double[] LandPercentage; 
	double[] Energy; 
	String[] Viewers; 
	int NoYears; 
	int[] Years;
	
	
	public ForestAREAvENERGYUse(double[] percent, double[] nrg, String[] views, int numberOfYears, int[] years ) 
	{
		this.LandPercentage = percent;
		this.Energy = nrg;
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
				System.out.println("ForestAREAvENERGYUse Pie Chart will be displayed");
			}
			else if(Viewers[i].equals("Line Graph"))
			{
				System.out.println("ForestAREAvENERGYUse Line Graph will be displayed");
//				Line lineGraph = new Line();
//				lineGraph.create(this);
//				System.out.println("Forest Line Graph will be displayed");
			}
			else if(Viewers[i].equals("Bar Graph"))
			{
				System.out.println("ForestAREAvENERGYUse Bar Graph will be displayed");
			}
			else if(Viewers[i].equals("Scatter Plot"))
			{
				System.out.println("ForestAREAvENERGYUse Scatter Plot will be displayed");
			}
			else if(Viewers[i].equals("Report"))
			{
				System.out.println("ForestAREAvENERGYUse Report will be displayed");
			}
		}
	}

}
