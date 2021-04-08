package statsVisualiser.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Bar class takes info from various data modules and generates a
 * ChartPanel containing a bar graph representation of the
 * collected data.
 * @author Jordi A. Cochegrus
 *
 */

public class Bar {
	
	/**
	 * Creates a bar graph of the requested analysis.
	 * @param requestForest	Forest object containing data for analysis
	 * @return ChartPanel containing bar graph
	 */
	public static ChartPanel create(Forest requestForest) {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		for(int i = 0; i < requestForest.NoYears; i++)
			dataset1.setValue((Number)requestForest.LandPercentage[i], "Forest Area (% of Total Land Area)", Double.toString(requestForest.Years[i]));
		
		CategoryPlot plot = new CategoryPlot();
		BarRenderer renderer1 = new BarRenderer();
		plot.setDataset(dataset1);
		plot.setRenderer(renderer1);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));
		plot.mapDatasetToRangeAxis(0, 0);
		JFreeChart chart = new JFreeChart("Forest Area", new Font("Serif", Font.BOLD, 18), plot, true);
		
		return Bar.plot(chart);
	}
	
	/**
	 * Creates a bar graph of the requested analysis.
	 * @param requestPvC	POPvCO2 object containing data for analysis
	 * @return ChartPanel containing bar graph
	 */
	public static ChartPanel create(POPvCO2 requestPvC) {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		for(int i = 0; i < requestPvC.NoYears; i++) {
			dataset1.setValue((Number)requestPvC.Populations[i], "Population", Double.toString(requestPvC.Years[i]));
			dataset2.setValue((Number)requestPvC.CO2[i], "CO2 Emissions (kg)", Double.toString(requestPvC.Years[i]));			
		}
		
		CategoryPlot plot = new CategoryPlot();
		BarRenderer renderer1 = new BarRenderer();
		BarRenderer renderer2 = new BarRenderer();
		plot.setDataset(0, dataset1);
		plot.setRenderer(0, renderer1);
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, renderer2);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("Pop"));
		plot.setRangeAxis(1, new NumberAxis("Kg"));
		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1);
		JFreeChart chart = new JFreeChart("Population vs CO2 Emissions", new Font("Serif", Font.BOLD, 18), plot, true);
		
		return Bar.plot(chart);
	}
	
	/**
	 * Creates a bar graph of the requested analysis.
	 * @param hospital	HspBeds object containing data for analysis
	 * @return ChartPanel containing bar graph
	 */
	public static ChartPanel create(HspBeds hospital) {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		for(int i = 0; i < hospital.NoYears; i++)
			dataset1.setValue((Number)hospital.HospitalBeds[i], "Hospital Beds/1000 people", Double.toString(hospital.Years[i]));
		
		CategoryPlot plot = new CategoryPlot();
		BarRenderer renderer1 = new BarRenderer();
		plot.setDataset(dataset1);
		plot.setRenderer(renderer1);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));
		plot.mapDatasetToRangeAxis(0, 0);
		JFreeChart chart = new JFreeChart("Hospital Beds", new Font("Serif", Font.BOLD, 18), plot, true);
		
		return Bar.plot(chart);
	}
	
	/**
	 * Creates a bar graph of the requested analysis.
	 * @param reuqestGDP	GDP object containing data for analysis
	 * @return ChartPanel containing bar graph
	 */
	public static ChartPanel create(GDP requestGDP) {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		for(int i = 0; i < requestGDP.NoYears; i++)
			dataset1.setValue((Number)requestGDP.GDPperCapita[i], "GDP per Capita (US Dollars)", Double.toString(requestGDP.Years[i]));
		
		CategoryPlot plot = new CategoryPlot();
		BarRenderer renderer1 = new BarRenderer();
		plot.setDataset(dataset1);
		plot.setRenderer(renderer1);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));
		plot.mapDatasetToRangeAxis(0, 0);
		JFreeChart chart = new JFreeChart("Gross Domestic Product", new Font("Serif", Font.BOLD, 18), plot, true);
		
		return Bar.plot(chart);
	}
	
	/**
	 * Creates a bar graph of the requested analysis.
	 * @param requestEvH	EDUCATIONvHEALTH object containing data for analysis
	 * @return ChartPanel containing bar graph
	 */
	public static ChartPanel create(EDUCATIONvHEALTH requestEvH) {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		for(int i = 0; i < requestEvH.NoYears; i++) {
			dataset1.setValue((Number)requestEvH.Education[i], "Education Budget", Double.toString(requestEvH.Years[i]));
			dataset1.setValue((Number)requestEvH.Health[i], "Health Budget", Double.toString(requestEvH.Years[i]));			
		}
		
		CategoryPlot plot = new CategoryPlot();
		BarRenderer renderer1 = new BarRenderer();
		plot.setDataset(0, dataset1);
		plot.setRenderer(0, renderer1);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("% of GDP"));
		plot.mapDatasetToRangeAxis(0, 0);
		JFreeChart chart = new JFreeChart("Education vs Health", new Font("Serif", Font.BOLD, 18), plot, true);
		
		return Bar.plot(chart);
	}
	
	/**
	 * Creates a bar graph of the requested analysis.
	 * @param healt	HealthPERCENTvCAPITA object containing data for analysis
	 * @return ChartPanel containing bar graph
	 */
	public static ChartPanel create(HealtPERCENTvCAPITA health) {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		for(int i = 0; i < health.NoYears; i++) {
			dataset1.setValue((Number)health.Percent[i], "% of GDP allocated to Health Expenses", Double.toString(health.Years[i]));
			dataset2.setValue((Number)health.Capita[i], "Health Expenses per Capita (current US Dollars)", Double.toString(health.Years[i]));			
		}
		
		CategoryPlot plot = new CategoryPlot();
		BarRenderer renderer1 = new BarRenderer();
		BarRenderer renderer2 = new BarRenderer();
		plot.setDataset(0, dataset1);
		plot.setRenderer(0, renderer1);
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, renderer2);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("% of GDP"));
		plot.setRangeAxis(1, new NumberAxis("$ per Capita"));
		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1);
		JFreeChart chart = new JFreeChart("Health Expenditure", new Font("Serif", Font.BOLD, 18), plot, true);
		
		return Bar.plot(chart);
	}
	
	/**
	 * Creates a bar graph of the requested analysis.
	 * @param requestFvE	ForestAREAvENERGYUse object containing data for analysis
	 * @return ChartPanel containing bar graph
	 */
	public static ChartPanel create(ForestAREAvENERGYUse requestFvE) {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		for(int i = 0; i < requestFvE.NoYears; i++) {
			dataset1.setValue((Number)requestFvE.LandPercentage[i], "Forest Area (% to Total Land Area)", Double.toString(requestFvE.Years[i]));
			dataset2.setValue((Number)requestFvE.Energy[i], "Energy Use (kg of oil equivalent per capita)", Double.toString(requestFvE.Years[i]));			
		}
		
		CategoryPlot plot = new CategoryPlot();
		BarRenderer renderer1 = new BarRenderer();
		BarRenderer renderer2 = new BarRenderer();
		plot.setDataset(0, dataset1);
		plot.setRenderer(0, renderer1);
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, renderer2);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("% of Total Land Area"));
		plot.setRangeAxis(1, new NumberAxis("kg of oil equivalent per capita"));
		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1);
		JFreeChart chart = new JFreeChart("Forest Area vs Energy Use", new Font("Serif", Font.BOLD, 18), plot, true);
		
		return Bar.plot(chart);
	}
	
	/**
	 * Creates a bar graph of the requested analysis.
	 * @param requestPvF	POLLUTIONvFOREST object containing data for analysis
	 * @return ChartPanel containing bar graph
	 */
	public static ChartPanel create(POLLUTIONvFOREST requestPvF) {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		for(int i = 0; i < requestPvF.NoYears; i++) {
			dataset1.setValue((Number)requestPvF.Pollution[i], "Air pollution, mean annual exposure (micrograms per cubic meter)", Double.toString(requestPvF.Years[i]));
			dataset2.setValue((Number)requestPvF.LandPercentage[i], "Forest Area (% of Total Land Area", Double.toString(requestPvF.Years[i]));			
		}
		
		CategoryPlot plot = new CategoryPlot();
		BarRenderer renderer1 = new BarRenderer();
		BarRenderer renderer2 = new BarRenderer();
		plot.setDataset(0, dataset1);
		plot.setRenderer(0, renderer1);
		plot.setDataset(1, dataset2);
		plot.setRenderer(1, renderer2);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("micrograms per cubic meter"));
		plot.setRangeAxis(1, new NumberAxis("% of Total Land Area"));
		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1);
		JFreeChart chart = new JFreeChart("Pollution vs Forest Area", new Font("Serif", Font.BOLD, 18), plot, true);
		
		return Bar.plot(chart);
	}
	
	/**
	 * Finalizes the ChartPanel object for the graph. 
	 * @param chart	JFreeChart to be placed into ChartPanel
	 * @return	ChartPanel containing bar graph
	 */
	private static ChartPanel plot(JFreeChart chart) {
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}
}
