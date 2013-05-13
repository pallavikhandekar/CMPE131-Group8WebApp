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
	public static void main(String[] args) throws Exception {
		int i=0;
		ArrayList<String> tStamp = new ArrayList<String>();
		ArrayList<String> iops = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sanramon?" + "user=sanramon&password=sanramon");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT MON_TIMESTAMP, IOPS FROM sanramon.monitor_data;");
			
			while (rs.next()) {
				tStamp.add(rs.getString("MON_TIMESTAMP"));
				iops.add(rs.getString("IOPS"));
				System.out.print(tStamp.get(i)+"\t"+iops.get(i)+"\n");
				i++;
			}//end while
		}//end try
		catch(Exception ex) {
			throw ex;
		}//end catch
	}//end main
}//end reportData
