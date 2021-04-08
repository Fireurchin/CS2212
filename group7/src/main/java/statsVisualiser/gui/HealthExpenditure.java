package statsVisualiser.gui;

public class HealthExpenditure {
	
	double[] Capita; 
	String[] Viewers; 
	int NoYears; 
	int[] Years;
	
	
	public HealthExpenditure(double[] cap, String[] views, int numberOfYears, int[] years ) 
	{
		this.Capita = cap;
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
				System.out.println("HealtPERCENTvCAPITA Pie Chart will be displayed");
			}
			else if(Viewers[i].equals("Line Graph"))
			{
				System.out.println("HealtPERCENTvCAPITA Line Graph will be displayed");
//				Line lineGraph = new Line();
//				lineGraph.create(this);
//				System.out.println("Forest Line Graph will be displayed");
			}
			else if(Viewers[i].equals("Bar Graph"))
			{
				System.out.println("HealtPERCENTvCAPITA Bar Graph will be displayed");
			}
			else if(Viewers[i].equals("Scatter Plot"))
			{
				System.out.println("HealtPERCENTvCAPITA Scatter Plot will be displayed");
			}
			else if(Viewers[i].equals("Report"))
			{
				System.out.println("HealtPERCENTvCAPITA Report will be displayed");
			}
		}
	}

}
