package statsVisualiser.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;

import java.nio.file.Paths;

/**
 * Takes a CSV file and stores all the countries into a useable list
 * @author Russell Henlin
 */

public class CountryList {

	private static final String COMMA_DELIMITER = ",";
	private static List<List<String>> records = new ArrayList<>();
	private List<String> countryNames = new ArrayList<>();
    private List<String> countryCodes = new ArrayList<>();
	
	public CountryList(String country_csv) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(country_csv))) {
		    String line = br.readLine();
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        records.add(Arrays.asList(values));
		    }
		    
		    for(int i = 0; i < records.size(); i++) {
		    	if (records.get(i).get(1).startsWith("\"") || records.get(i).get(5).matches("N/A")) 
		    	{} 
		    	else 
		    	{
		    		countryNames.add(records.get(i).get(1));
		    		countryCodes.add(records.get(i).get(5));
		    	}
		    		
		    }
		    
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	//How many countries List
	public int size() 
	{
		return countryNames.size();
	}




//Print all records from the CSV
	public List<List<String>> records() {
		return records;
	}
	
	//Print all country names from list
	public List<String> list() {
		return countryNames;
	}
	
	//Print all country names from list
	public List<String> codes() {
		return countryCodes;
	}
	
	//Retrieve ISO of country based on name
	public String countryISO(String countryName) {
		
			int index = countryNames.indexOf(countryName);
			
			String ISO = records.get(index).get(5);
			
			return ISO;
			
	}
	
	//Retrieve valid start year of data
	public String startYear(String countryName) {
		
		int index = countryNames.indexOf(countryName);
		
		String startYear = records.get(index).get(6);
		
		return startYear;
		
	}
	
	//Retrieve valid end year of data
	public String endYear(String countryName) {
		
		int index = countryNames.indexOf(countryName);
		
		String endYear = records.get(index).get(7);
		if(endYear.equals("Now"))
			return Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		else
			return endYear;
		
	}
	
}
