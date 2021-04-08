package statsVisualiser.gui;

public class POLLUTIONvFOREST {
	
	double[] Pollution; 
	double[] LandPercentage; 
	String[] Viewers; 
	int NoYears; 
	int[] Years;
	
	
	public POLLUTIONvFOREST(double[] pollute, double[] percent, String[] views, int numberOfYears, int[] years ) 
	{
		this.Pollution = pollute;
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
				System.out.println("POLLUTIONvFOREST Pie Chart will be displayed");
			}
			else if(Viewers[i].equals("Line Graph"))
			{
				System.out.println("POLLUTIONvFOREST Line Graph will be displayed");
//				Line lineGraph = new Line();
//				lineGraph.create(this);
//				System.out.println("Forest Line Graph will be displayed");
			}
			else if(Viewers[i].equals("Bar Graph"))
			{
				System.out.println("POLLUTIONvFOREST Bar Graph will be displayed");
			}
			else if(Viewers[i].equals("Scatter Plot"))
			{
				System.out.println("POLLUTIONvFOREST Scatter Plot will be displayed");
			}
			else if(Viewers[i].equals("Report"))
			{
				System.out.println("POLLUTIONvFOREST Report will be displayed");
			}
		}
	}

}
