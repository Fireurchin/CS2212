package statsVisualiser.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Line class takes info from various data modules and generates a
 * ChartPanel containing a line graph representation of the
 * collected data.
 * @author Jordi A. Cochegrus
 *
 */

public class Line {
	
	/**
	 * Creates a line graph of the requested analysis.
	 * @param requestForest	Forest object containing data for analysis
	 * @return ChartPanel containing line graph
	 */
	public static ChartPanel create(Forest requestForest) {
		XYSeries series1 = new XYSeries("");
		for(int i = 0; i < requestForest.NoYears; i++)
			series1.add((double)requestForest.Years[i], requestForest.LandPercentage[i]);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		JFreeChart chart = ChartFactory.createXYLineChart("Forest Area", "Year", "% of Total Land Area", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		
		TextTitle title = new TextTitle("Forest Area", new Font("Serif", Font.BOLD, 18));
		
		return Line.plot(chart, title);
	}
	
	/**
	 * Creates a line graph of the requested analysis.
	 * @param requestPvC	POPvCO2 object containing data for analysis
	 * @return ChartPanel containing line graph
	 */
	public static ChartPanel create(POPvCO2 requestPvC) {
		XYSeries series1 = new XYSeries("Total Population");
		for(int i = 0; i < requestPvC.NoYears; i++)
			series1.add((double)requestPvC.Years[i], requestPvC.Populations[i]);
		
		XYSeries series2 = new XYSeries("Emissions");
		for(int j = 0; j < requestPvC.NoYears; j++)
			series2.add((double)requestPvC.Years[j], requestPvC.CO2[j]);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		JFreeChart chart = ChartFactory.createXYLineChart("Population vs CO2 Emissions", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		
		TextTitle title = new TextTitle("Population vs CO2 Emissions", new Font("Serif", Font.BOLD, 18));
		
		return Line.plot(chart, title);
	}
	
	/**
	 * Creates a line graph of the requested analysis.
	 * @param hospital	HspBeds object containing data for analysis
	 * @return ChartPanel containing line graph
	 */
	public static ChartPanel create(HspBeds hospital) {
		XYSeries series1 = new XYSeries("Hospital Beds/1000 people");
		for(int i = 0; i < hospital.NoYears; i++)
			series1.add((double)hospital.Years[i], hospital.HospitalBeds[i]);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		JFreeChart chart = ChartFactory.createXYLineChart("Hospital Beds", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		
		TextTitle title = new TextTitle("Hospital Beds", new Font("Serif", Font.BOLD, 18));
		
		return Line.plot(chart, title);
	}
	
	/**
	 * Creates a line graph of the requested analysis.
	 * @param requestGDP	GDP object containing data for analysis
	 * @return ChartPanel containing line graph
	 */
	public static ChartPanel create(GDP requestGDP) {
		XYSeries series1 = new XYSeries("GDP per Capita (US Dollars)");
		for(int i = 0; i < requestGDP.NoYears; i++)
			series1.add((double)requestGDP.Years[i], requestGDP.GDPperCapita[i]);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		JFreeChart chart = ChartFactory.createXYLineChart("Gross Domestic Product", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		
		TextTitle title = new TextTitle("Gross Domestic Product", new Font("Serif", Font.BOLD, 18));
		
		return Line.plot(chart, title);
	}
	
	/**
	 * Creates a line graph of the requested analysis.
	 * @param requestEvH	EDUCATIONvHEALTH object containing data for analysis
	 * @return ChartPanel containing line graph
	 */
	public static ChartPanel create(EDUCATIONvHEALTH requestEvH) {
		XYSeries series1 = new XYSeries("Education Expenditures");
		for(int i = 0; i < requestEvH.NoYears; i++)
			series1.add((double)requestEvH.Years[i], requestEvH.Education[i]);
		
		XYSeries series2 = new XYSeries("HealthExpenditures");
		for(int j = 0; j < requestEvH.NoYears; j++)
			series2.add((double)requestEvH.Years[j], requestEvH.Health[j]);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		JFreeChart chart = ChartFactory.createXYLineChart("Education vs Health", "Year", "% of GDP", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		
		TextTitle title = new TextTitle("Education vs Health", new Font("Serif", Font.BOLD, 18));
		
		return Line.plot(chart, title);
	}
	
	/**
	 * Creates a line graph of the requested analysis.
	 * @param health	HealtPERCENTvCAPITA object containing data for analysis
	 * @return ChartPanel containing line graph
	 */
	public static ChartPanel create(HealtPERCENTvCAPITA health) {
		XYSeries series1 = new XYSeries("% of GDP");
		for(int i = 0; i < health.NoYears; i++)
			series1.add((double)health.Years[i], health.Percent[i]);
		
		XYSeries series2 = new XYSeries("Current US$ per Capita");
		for(int j = 0; j < health.NoYears; j++)
			series2.add((double)health.Years[j], health.Capita[j]);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		JFreeChart chart = ChartFactory.createXYLineChart("Health Expenditure", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		
		TextTitle title = new TextTitle("Health Expenditure", new Font("Serif", Font.BOLD, 18));
		
		return Line.plot(chart, title);
	}
	
	/**
	 * Creates a line graph of the requested analysis.
	 * @param requestFvE	POPvCO2 object containing data for analysis
	 * @return ChartPanel containing line graph
	 */
	public static ChartPanel create(ForestAREAvENERGYUse requestFvE) {
		XYSeries series1 = new XYSeries("Forest Area (% of Total Land Area");
		for(int i = 0; i < requestFvE.NoYears; i++)
			series1.add((double)requestFvE.Years[i], requestFvE.LandPercentage[i]);
		
		XYSeries series2 = new XYSeries("Energy Use (kg of oil equivalent per capita");
		for(int j = 0; j < requestFvE.NoYears; j++)
			series2.add((double)requestFvE.Years[j], requestFvE.Energy[j]);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		JFreeChart chart = ChartFactory.createXYLineChart("Forest Area vs Energy Use", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		
		TextTitle title = new TextTitle("Forest Area vs Energy Use", new Font("Serif", Font.BOLD, 18));
		
		return Line.plot(chart, title);
	}
	
	/**
	 * Creates a line graph of the requested analysis.
	 * @param requestPvF	POLLUTIONvFOREST object containing data for analysis
	 * @return ChartPanel containing line graph
	 */
	public static ChartPanel create(POLLUTIONvFOREST requestPvF) {
		XYSeries series1 = new XYSeries("Air Pollution, Mean Annual Exposure) micrograms per cubic meter");
		for(int i = 0; i < requestPvF.NoYears; i++)
			series1.add((double)requestPvF.Years[i], requestPvF.Pollution[i]);
		
		XYSeries series2 = new XYSeries("Forest Area (% of Total Land Area)");
		for(int j = 0; j < requestPvF.NoYears; j++)
			series2.add((double)requestPvF.Years[j], requestPvF.LandPercentage[j]);
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		JFreeChart chart = ChartFactory.createXYLineChart("Air Pollution vs Forest Area", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		
		TextTitle title = new TextTitle("Air Pollution vs Forest Area", new Font("Serif", Font.BOLD, 18));
		
		return Line.plot(chart, title);
	}
	
	/**
	 * Finalizes the ChartPanel object for the graph. 
	 * @param chart	JFreeChart to be placed into ChartPanel
	 * @param title	TextTile to be used for chart
	 * @return	ChartPanel containing line graph
	 */
	private static ChartPanel plot(JFreeChart chart, TextTitle title) {
		XYPlot plot = chart.getXYPlot();
		
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);
		chart.setTitle(title);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}
}
