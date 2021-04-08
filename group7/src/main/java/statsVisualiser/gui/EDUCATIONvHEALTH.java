package statsVisualiser.gui;

public class EDUCATIONvHEALTH {
	
	double[] Education; 
	double[] Health; 
	String[] Viewers; 
	int NoYears; 
	int[] Years;
	
	
	public EDUCATIONvHEALTH(double[] edu, double[] heal, String[] views, int numberOfYears, int[] years ) 
	{
		this.Education = edu;
		this.Health = heal;
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
				System.out.println("EDUCATIONvHEALTH Pie Chart will be displayed");
			}
			else if(Viewers[i].equals("Line Graph"))
			{
				System.out.println("EDUCATIONvHEALTH Line Graph will be displayed");
//				Line lineGraph = new Line();
//				lineGraph.create(this);
//				System.out.println("Forest Line Graph will be displayed");
			}
			else if(Viewers[i].equals("Bar Graph"))
			{
				System.out.println("EDUCATIONvHEALTH Bar Graph will be displayed");
			}
			else if(Viewers[i].equals("Scatter Plot"))
			{
				System.out.println("EDUCATIONvHEALTH Scatter Plot will be displayed");
			}
			else if(Viewers[i].equals("Report"))
			{
				System.out.println("EDUCATIONvHEALTH Report will be displayed");
			}
		}
	}

}
