import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;	
import java.sql.Statement;
import java.util.*;

public class reportData extends MonitoringData {

	/**
	 * @param args
	 * Author: Rajwinder Ruprai
	 * @throws Exception 
	 */
	
	public static void main (String[] args) throws Exception {
		ArrayList<String> tStamp = new ArrayList<String>();
		ArrayList<String> iops = new ArrayList<String>();
		try {
			int i=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sanramon?" + "user=sanramon&password=sanramon");
			Statement st = con.createStatement();
			//query only timestamp (x-axis) and iops (y-axis) so we can do a graph based on those two fields
			ResultSet rs = st.executeQuery("SELECT MON_TIMESTAMP, IOPS FROM sanramon.monitor_data;"); 
			
			/*
			 * If anyone want to get a random time stamp and iops information,
			 * they would have to call tStamp.get(i) and iops.get(i) where i is the index 
			 * the "i" has to be the same number
			 * essentially two arraylists were created so index 2 in tStamp goes with index 2 in iops, for example				 * 
			 */
			
			while (rs.next()) {
				//add the appropriate time stamp
				tStamp.add(rs.getString("MON_TIMESTAMP"));
				
				//also add the corresponding iops for that time stamp
				iops.add(rs.getString("IOPS")); 	
				
				//i am printing to console so everyone can see the data it pulls matches csv
				System.out.print("\n" + tStamp.get(i) + "\t" + iops.get(i) + "\n"); 
				i++; //increment index
			}//end while
		}//end try
		catch(Exception ex) {
			throw ex;
		}//end catch
	}//end accessData
}//end reportData
