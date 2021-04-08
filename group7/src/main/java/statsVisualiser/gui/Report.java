package statsVisualiser.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Report class takes info from various data modules and generates a
 * JScrollPane containing a general report of the collected data.
 * @author Jordi A. Cochegrus
 *
 */

public class Report {
	
	/**
	 * Creates a general report of the requested analysis.
	 * @param requestForest	Forest object containing data for analysis
	 * @return JScrollPane containing general report
	 */
	public static JScrollPane create(Forest requestForest) {
		String reportMessage = "Forest Area (% of Total Land Area)\n"
				+ "==============================\n";
		
		for(int i = 0; i < requestForest.NoYears; i++) {
			if(i != 0) reportMessage += "\n";
			String year = Integer.toString(requestForest.Years[i]);
			String percentage = Double.toString(requestForest.LandPercentage[i]);
			reportMessage += "Year " + year + ":\n"
					+ "Forest Area => " + percentage + "%\n";
		}

//		*Use this for testing*
//		System.out.println(reportMessage);
		return Report.write(reportMessage);
	}
	
	/**
	 * Creates a general report of the requested analysis.
	 * @param requestPvC	POPvCO2 object containing data for analysis
	 * @return JScrollPane containing general report
	 */
	public static JScrollPane create(POPvCO2 requestPvC) {
		String reportMessage = "Population vs CO2 Emissions\n"
				+ "==============================\n";
		
		for(int i = 0; i < requestPvC.NoYears; i++) {
			if(i != 0) reportMessage += "\n";
			String year = Integer.toString(requestPvC.Years[i]);
			String kilos = Double.toString(requestPvC.CO2[i]);
			String pop = Integer.toString(requestPvC.Populations[i]);
			reportMessage += "Year " + year + ":\n"
					+ "Population    => " + pop + "\n"
					+ "CO2 Emissions => " + kilos + "kg\n";
		}
		
//		*Use this for testing*
//		System.out.println(reportMessage);
		return Report.write(reportMessage);
	}
	
	/**
	 * Creates a general report of the requested analysis.
	 * @param hospital	HspBeds object containing data for analysis
	 * @return JScrollPane containing general report
	 */
	public static JScrollPane create(HspBeds hospital) {
		String reportMessage = "Hospital Beds (per 1000 People)\n"
				+ "==============================\n";
		
		for(int i = 0; i < hospital.NoYears; i++) {
			if(i != 0) reportMessage += "\n";
			String year = Integer.toString(hospital.Years[i]);
			String beds = Double.toString(hospital.HospitalBeds[i]);
			reportMessage += "Year " + year + ":\n"
					+ "Hospital Beds => " + beds + "\n";
		}
		
//		*Use this for testing*
//		System.out.println(reportMessage);
		return Report.write(reportMessage);
	}
	
	/**
	 * Creates a general report of the requested analysis.
	 * @param requestGDP	GDP object containing data for analysis
	 * @return JScrollPane containing general report
	 */
	public static JScrollPane create(GDP requestGDP) {
		String reportMessage = "Gross Domestic Product (US Dollars)\n"
				+ "==============================\n";
		
		for(int i = 0; i < requestGDP.NoYears; i++) {
			if(i != 0) reportMessage += "\n";
			String year = Integer.toString(requestGDP.Years[i]);
			String capita = Double.toString(requestGDP.GDPperCapita[i]);
			reportMessage += "Year " + year + ":\n"
					+ "GDP per Capita => $" + capita + "\n";
		}
		
//		*Use this for testing*
//		System.out.println(reportMessage);
		return Report.write(reportMessage);
	}
	
	/**
	 * Creates a general report of the requested analysis.
	 * @param requestEvH	EDUCATIONvHEALTH object containing data for analysis
	 * @return JScrollPane containing general report
	 */
	public static JScrollPane create(EDUCATIONvHEALTH requestEvH) {
		String reportMessage = "Education vs Health (% of GDP)\n"
				+ "==============================\n";
		
		for(int i = 0; i < requestEvH.NoYears; i++) {
			if(i != 0) reportMessage += "\n";
			String year = Integer.toString(requestEvH.Years[i]);
			String edu = Double.toString(requestEvH.Education[i]);
			String health = Double.toString(requestEvH.Health[i]);
			reportMessage += "Year " + year + ":\n"
					+ "Education Budget => %" + edu + "\n"
					+ "Health Budget 	=> %" + health + "\n";
		}
		
//		*Use this for testing*
//		System.out.println(reportMessage);
		return Report.write(reportMessage);
	}
	
	/**
	 * Creates a general report of the requested analysis.
	 * @param health	HealthPERCENTvCAPITA object containing data for analysis
	 * @return JScrollPane containing general report
	 */
	public static JScrollPane create(HealtPERCENTvCAPITA health) {
		String reportMessage = "Health Expenditure\n"
				+ "==============================\n";
		
		for(int i = 0; i < health.NoYears; i++) {
			if(i != 0) reportMessage += "\n";
			String year = Integer.toString(health.Years[i]);
			String percentage = Double.toString(health.Percent[i]);
			String value = Double.toString(health.Capita[i]);
			reportMessage += "Year " + year + ":\n"
					+ "Expenditure as % of (total) GDP      => " + percentage + "%\n"
					+ "Expenditure per Capita (current US$) => $" + value + "\n";
		}
		
//		*Use this for testing*
//		System.out.println(reportMessage);
		return Report.write(reportMessage);
	}
	
	/**
	 * Creates a general report of the requested analysis.
	 * @param requestFvE	ForestAREAvENERGYUse object containing data for analysis
	 * @return JScrollPane containing general report
	 */
	public static JScrollPane create(ForestAREAvENERGYUse requestFvE) {
		String reportMessage = "Energy Use vs Forest Area\n"
				+ "==============================\n";
		
		for(int i = 0; i < requestFvE.NoYears; i++) {
			if(i != 0) reportMessage += "\n";
			String year = Integer.toString(requestFvE.Years[i]);
			String area = Double.toString(requestFvE.LandPercentage[i]);
			String kg = Double.toString(requestFvE.Energy[i]);
			reportMessage += "Year " + year + ":\n"
					+ "Energy Use (oil Equivalent per Capita) => " + kg + "kg\n"
					+ "Forest Area (% of Total Land Area)     => %" + area + "\n";
		}
		
//		*Use this for testing*
//		System.out.println(reportMessage);
		return Report.write(reportMessage);
	}
	
	/**
	 * Creates a general report of the requested analysis.
	 * @param requestPvF	POLLUTIONvFOREST object containing data for analysis
	 * @return JScrollPane containing general report
	 */
	public static JScrollPane create(POLLUTIONvFOREST requestPvF) {
		String reportMessage = "Pollution vs Forest Area\n"
				+ "==============================\n";
		
		for(int i = 0; i < requestPvF.NoYears; i++) {
			if(i != 0) reportMessage += "\n";
			String year = Integer.toString(requestPvF.Years[i]);
			String area = Double.toString(requestPvF.LandPercentage[i]);
			String mg = Double.toString(requestPvF.Pollution[i]);
			reportMessage += "Year " + year + ":\n"
					+ "Air Pollution (Mean Annual Exposure) => " + mg + "mg/m^3\n"
					+ "Forest Area (% of Total Land Area) => %" + area + "\n";
		}
		
//		*Use this for testing*
//		System.out.println(reportMessage);
		return Report.write(reportMessage);
	}
	
	/**
	 * Finalizes the JScrollPane object for the desired report. 
	 * @param reportMessage	String containing report to be displayed
	 * @return	JScrollPane containing general report
	 */
	private static JScrollPane write(String reportMessage) {
		JTextArea report = new JTextArea();
		report.setEditable(false);
		report.setPreferredSize(new Dimension(400,300));
		report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		report.setBackground(Color.white);
		report.setText(reportMessage);		
		JScrollPane outputScrollPane = new JScrollPane(report);
		return outputScrollPane;
	}
	
}
