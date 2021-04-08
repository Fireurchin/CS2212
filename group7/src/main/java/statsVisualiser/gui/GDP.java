package statsVisualiser.gui;

public class GDP {
	
	double[] GDPperCapita; 
	String[] Viewers; 
	int NoYears; 
	int[] Years;
	
	
	public GDP(double[] gdp, String[] views, int numberOfYears, int[] years)
	{
		this.GDPperCapita = gdp;
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
				System.out.println("GDP Pie Chart will be displayed");
			}
			else if(Viewers[i].equals("Line Graph"))
			{
				System.out.println("GDP Line Graph will be displayed");
//				Line lineGraph = new Line();
//				lineGraph.create(this);
//				System.out.println("Forest Line Graph will be displayed");
			}
			else if(Viewers[i].equals("Bar Graph"))
			{
				System.out.println("GDP Bar Graph will be displayed");
			}
			else if(Viewers[i].equals("Scatter Plot"))
			{
				System.out.println("GDP Scatter Plot will be displayed");
			}
			else if(Viewers[i].equals("Report"))
			{
				System.out.println("GDP Report will be displayed");
			}
		}
	}

}
