package statsVisualiser.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

/**
 * Scatter class takes info from various data modules and generates a
 * ChartPanel containing a scatter plot graph representation of the
 * collected data.
 * @author Jordi A. Cochegrus
 *
 */

public class Scatter {
	
	/**
	 * Creates a scatter plot graph of the requested analysis.
	 * @param requestForest	Forest object containing data for analysis
	 * @return ChartPanel containing scatter plot graph
	 */
	public static ChartPanel create(Forest requestForest) {
		TimeSeries series1 = new TimeSeries("Forest Area (% of Total Land Area)");
		for(int i = 0; i < requestForest.NoYears; i++)
			series1.add(new Year(requestForest.Years[i]), requestForest.LandPercentage[i]);
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		plot.setDomainAxis(new DateAxis("Year"));
		plot.setRangeAxis(new NumberAxis(""));
		plot.mapDatasetToRangeAxis(0, 0);

		JFreeChart chart = new JFreeChart("Forest Area",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		
		return Scatter.plot(chart);
	}
	
	/**
	 * Creates a scatter plot graph of the requested analysis.
	 * @param hospital	HspBeds object containing data for analysis
	 * @return ChartPanel containing scatter plot graph
	 */
	public static ChartPanel create(HspBeds hospital) {
		TimeSeries series1 = new TimeSeries("Hospital Beds/1000 people");
		for(int i = 0; i < hospital.NoYears; i++)
			series1.add(new Year(hospital.Years[i]), hospital.HospitalBeds[i]);
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		plot.setDomainAxis(new DateAxis("Year"));
		plot.setRangeAxis(new NumberAxis(""));
		plot.mapDatasetToRangeAxis(0, 0);

		JFreeChart chart = new JFreeChart("Hospital Beds",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		
		return Scatter.plot(chart);
	}
	
	/**
	 * Creates a scatter plot graph of the requested analysis.
	 * @param requestGDP	GDP object containing data for analysis
	 * @return ChartPanel containing scatter plot graph
	 */
	public static ChartPanel create(GDP requestGDP) {
		TimeSeries series1 = new TimeSeries("GDP per Capita");
		for(int i = 0; i < requestGDP.NoYears; i++)
			series1.add(new Year(requestGDP.Years[i]), requestGDP.GDPperCapita[i]);
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		plot.setDomainAxis(new DateAxis("Year"));
		plot.setRangeAxis(new NumberAxis(""));
		plot.mapDatasetToRangeAxis(0, 0);

		JFreeChart chart = new JFreeChart("Gross Domestic Product",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		
		return Scatter.plot(chart);
	}
	
	/**
	 * Creates a scatter plot graph of the requested analysis.
	 * @param requestFvE	ForestAREAvENERGYUse object containing data for analysis
	 * @return ChartPanel containing scatter plot graph
	 */
	public static ChartPanel create(ForestAREAvENERGYUse requestFvE) {
		TimeSeries series1 = new TimeSeries("Forest Area (% of Total Land Area");
		TimeSeries series2 = new TimeSeries("Energy Use (kg of oil equivalent per capita)");
		for(int i = 0; i < requestFvE.NoYears; i++) {
			series1.add(new Year(requestFvE.Years[i]), requestFvE.LandPercentage[i]);
			series2.add(new Year(requestFvE.Years[i]), requestFvE.Energy[i]);
		}
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset.addSeries(series2);
		
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		plot.setDomainAxis(new DateAxis("Year"));
		plot.setRangeAxis(0, new NumberAxis("% of Total Land Area"));
		
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("kg of Oil Equivalent per Capita"));
		
		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1);

		JFreeChart chart = new JFreeChart("Forest Area vs Energy Use",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		
		return Scatter.plot(chart);
	}
	
	/**
	 * Creates a scatter plot graph of the requested analysis.
	 * @param requestEvH	EDUCATIONvHEALTH object containing data for analysis
	 * @return ChartPanel containing scatter plot graph
	 */
	public static ChartPanel create(EDUCATIONvHEALTH requestEvH) {
		TimeSeries series1 = new TimeSeries("Education Budget");
		TimeSeries series2 = new TimeSeries("Health Budget");
		for(int i = 0; i < requestEvH.NoYears; i++) {
			series1.add(new Year(requestEvH.Years[i]), requestEvH.Education[i]);
			series2.add(new Year(requestEvH.Years[i]), requestEvH.Health[i]);
		}
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		
		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		plot.setDomainAxis(new DateAxis("Year"));
		plot.setRangeAxis(0, new NumberAxis("% of Total GDP"));
		
		plot.mapDatasetToRangeAxis(0, 0);

		JFreeChart chart = new JFreeChart("Education vs Health",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		
		return Scatter.plot(chart);
	}
	
	/**
	 * Creates a scatter plot graph of the requested analysis.
	 * @param health	HealthPERCENTvCAPITA object containing data for analysis
	 * @return ChartPanel containing scatter plot graph
	 */
	public static ChartPanel create(HealtPERCENTvCAPITA health) {
		TimeSeries series1 = new TimeSeries("Expenditure (% of GDP)");
		TimeSeries series2 = new TimeSeries("Expenditure per Capita (current US$");
		for(int i = 0; i < health.NoYears; i++) {
			series1.add(new Year(health.Years[i]), health.Percent[i]);
			series2.add(new Year(health.Years[i]), health.Capita[i]);
		}
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset.addSeries(series2);
		
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		plot.setDomainAxis(new DateAxis("Year"));
		plot.setRangeAxis(0, new NumberAxis("%"));
		
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("$"));
		
		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1);

		JFreeChart chart = new JFreeChart("Health Expenditure",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		
		return Scatter.plot(chart);
	}
	
	/**
	 * Creates a scatter plot graph of the requested analysis.
	 * @param requestPvC	POPvCO2 object containing data for analysis
	 * @return ChartPanel containing scatter plot graph
	 */
	public static ChartPanel create(POPvCO2 requestPvC) {
		TimeSeries series1 = new TimeSeries("Population");
		TimeSeries series2 = new TimeSeries("CO2 Emissions (Kg)");
		for(int i = 0; i < requestPvC.NoYears; i++) {
			series1.add(new Year(requestPvC.Years[i]), requestPvC.Populations[i]);
			series2.add(new Year(requestPvC.Years[i]), requestPvC.CO2[i]);
		}
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset.addSeries(series2);
		
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		plot.setDomainAxis(new DateAxis("Year"));
		plot.setRangeAxis(0, new NumberAxis("Population"));
		
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("Kg"));
		
		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1);

		JFreeChart chart = new JFreeChart("Population vs CO2 Emissions",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		
		return Scatter.plot(chart);
	}
	
	/**
	 * Creates a scatter plot graph of the requested analysis.
	 * @param requestPvF	POLLUTIONvFOREST object containing data for analysis
	 * @return ChartPanel containing scatter plot graph
	 */
	public static ChartPanel create(POLLUTIONvFOREST requestPvF) {
		TimeSeries series1 = new TimeSeries("Pollution, Mean Annual Exposure (micrograms per cubic meters");
		TimeSeries series2 = new TimeSeries("Forest Area (% of Total Land Area");
		for(int i = 0; i < requestPvF.NoYears; i++) {
			series1.add(new Year(requestPvF.Years[i]), requestPvF.Pollution[i]);
			series2.add(new Year(requestPvF.Years[i]), requestPvF.LandPercentage[i]);
		}
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset.addSeries(series2);
		
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		plot.setDomainAxis(new DateAxis("Year"));
		plot.setRangeAxis(0, new NumberAxis("micrograms per cubic meter"));
		
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("% of Total Land Area"));
		
		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1);

		JFreeChart chart = new JFreeChart("Pollution vs Forest Area",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		
		return Scatter.plot(chart);
	}
	
	/**
	 * Finalizes the ChartPanel object for the graph. 
	 * @param chart	JFreeChart to be placed into ChartPanel
	 * @return	ChartPanel containing scatter plot graph
	 */
	private static ChartPanel plot(JFreeChart chart) {
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}
	
}
