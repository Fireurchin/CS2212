package statsVisualiser.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Pie class takes info from various data modules and generates a
 * ChartPanel containing a pie chart representation of the collected data.
 * @author Jordi A. Cochegrus
 *
 */

public class Pie {
	
	/**
	 * Creates a pie chart of the requested analysis.
	 * @param requestForest	Forest object containing data for analysis
	 * @return ChartPanel containing pie chart
	 */
	public static ChartPanel create(Forest requestForest) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i = 0; i < requestForest.NoYears; i++) {
			dataset.addValue(requestForest.LandPercentage[i], "Forest Area", Integer.toString(requestForest.Years[i]));
			dataset.addValue((100 - requestForest.LandPercentage[i]), "Other Land Area", Integer.toString(requestForest.Years[i]));
		}
		
		JFreeChart chart = ChartFactory.createMultiplePieChart("Forest Area",
		dataset, TableOrder.BY_COLUMN, true, true, false);
		
		return Pie.plot(chart);
	}
	
/**	/**
	 * Creates a pie chart of the requested analysis.
	 * @param requestEvH	EDUCATIONvHEALTH object containing data for analysis
	 * @return ChartPanel containing pie chart
	 *
	public static ChartPanel create(EDUCATIONvHEALTH requestEvH) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Forest Area", requestEvH.Education[0]);
		dataset.setValue("Other Land Area", 100 - requestEvH.Health[0]);
			
		JFreeChart chart = ChartFactory.createPieChart("Forest Area - " + requestEvH.Years[0],
				dataset, true, true, false);
//		JFreeChart test = ChartFactory.createMultiplePieChart("Forest Area - " + requestForest.Years[0],
//		dataset, TableOrder.BY_COLUMN, true, true, false);
		
		return Pie.plot(chart);
	}
	*/
	
	/**
	 * Creates a pie chart of the requested analysis.
	 * @param requestEvH	EDUCATIONvHEALTH object containing data for analysis
	 * @return ChartPanel containing pie chart
	 */
	public static ChartPanel create(EDUCATIONvHEALTH requestEvH) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i = 0; i < requestEvH.NoYears; i++) {
			dataset.addValue(requestEvH.Education[i], "Education Expenditure (% of GDP)", Integer.toString(requestEvH.Years[i]));
			dataset.addValue(requestEvH.Health[i], "Health Expenditure (% of GDP)", Integer.toString(requestEvH.Years[i]));
			dataset.addValue((100 - requestEvH.Education[i] - requestEvH.Health[i]),
					"", Integer.toString(requestEvH.Years[i]));
		}
		
		JFreeChart chart = ChartFactory.createMultiplePieChart("Education vs Health",
		dataset, TableOrder.BY_COLUMN, true, true, false);
		
		return Pie.plot(chart);
	}
	
	/**
	 * Finalizes the ChartPanel object for the graph. 
	 * @param chart	JFreeChart to be placed into ChartPanel
	 * @return	ChartPanel containing pie graph
	 */
	private static ChartPanel plot(JFreeChart chart) {
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		return chartPanel;
	}
}
