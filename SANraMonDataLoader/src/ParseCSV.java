import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.*;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

/***
 * Parse CSV Data and Map to OBJECTS
 * @author Pallavi
 *
 */
public class ParseCSV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String monitoringDataFilename = "/Users/palloabhi/Downloads/SANData-111485.csv";
		String configutaionDataFilename = "/Users/palloabhi/Downloads/Sample_Org_Data_1.csv";
		ParseCSV parseCSVFile = new ParseCSV();
        System.out.println("Starting to parse CSV file and map to Java Bean");
        parseCSVFile.loadMonitoringData(monitoringDataFilename);
        parseCSVFile.loadConfigurationData(configutaionDataFilename);

	}

	/**
	 * Maps csv data to MonitoringData object
	 * @param filename
	 */
	  private void loadMonitoringData(String filename) {

	        try {
	                // To ignore Processing of 1st row
	                CSVReader reader = new CSVReader(new FileReader(filename));
	                System.out.println("Loaded reader");
	                ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
	                mappingStrategy.setType(MonitoringData.class);
	                System.out.println("Set mapping");
	              
	                // Columns for Monitor Data
	                String[] columns = new String[] { "io_type","io_channel", "lun", 
	                		"timestamp", "IP_address", "number_of_data_blocks","duration" ,"iops"};
	                mappingStrategy.setColumnMapping(columns);

	                CsvToBean csv = new CsvToBean();
	                List<MonitoringData> monitoringDataList = csv.parse(mappingStrategy, reader);
	                for (int i = 0; i < monitoringDataList.size(); i++) {
	                        MonitoringData monitoringData = monitoringDataList.get(i);
	                }

	        } catch (FileNotFoundException e) {
	                        e.printStackTrace();
	                }
	        }
	  
	  /**
	   * Maps csv data to ConfigurationData object
	   * @param filename
	   */
	  private void loadConfigurationData(String filename) {

	        try {
	                // To ignore Processing of 1st row
	                CSVReader reader = new CSVReader(new FileReader(filename));
	                System.out.println("Loaded reader");
	                ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
	                mappingStrategy.setType(ConfigurationData.class);
	                System.out.println("Set mapping");
	              
	              //Columns for Configuration Data
	                String[] columns = new String[] { "company","department", "user_Id", 
	                		"user_Name", "IP_address", "lun","io_channel"};
	                mappingStrategy.setColumnMapping(columns);

	                CsvToBean csv = new CsvToBean();
	                List<ConfigurationData> configurationDataList = csv.parse(mappingStrategy, reader);
	                for (int i = 0; i < configurationDataList.size(); i++) {
	                        ConfigurationData configurationData = configurationDataList.get(i);
	                        System.out.println(configurationData.user_Name);
	                }

	        } catch (FileNotFoundException e) {
	                        e.printStackTrace();
	                }
	        }
	  
	  
	}
	 

