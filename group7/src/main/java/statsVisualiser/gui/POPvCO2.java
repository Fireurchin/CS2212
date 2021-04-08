package statsVisualiser.gui;

public class POPvCO2 {
	
	int[] Populations;
	double[] CO2; 
	String[] Viewers; 
	int NoYears; 
	int[] Years;
	
	
	public POPvCO2(int[] pop, double[] co, String[] views, int numberOfYears, int[] years )
	{
		this.Populations = pop;
		this.CO2 = co;
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
				System.out.println("POPvCO2 Pie Chart will be displayed");
			}
			else if(Viewers[i].equals("Line Graph"))
			{
				System.out.println("POPvCO2 Line Graph will be displayed");
//				Line lineGraph = new Line();
//				lineGraph.create(this);
//				System.out.println("Forest Line Graph will be displayed");
			}
			else if(Viewers[i].equals("Bar Graph"))
			{
				System.out.println("POPvCO2 Bar Graph will be displayed");
			}
			else if(Viewers[i].equals("Scatter Plot"))
			{
				System.out.println("POPvCO2 Scatter Plot will be displayed");
			}
			else if(Viewers[i].equals("Report"))
			{
				System.out.println("POPvCO2 Report will be displayed");
			}
		}
	}

}
