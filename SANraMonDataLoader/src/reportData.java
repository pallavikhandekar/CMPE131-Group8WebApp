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
		//String url = null;
		//String usname = null;
		//String pwrd = null;
		ArrayList<String> list = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sanramon?" + "user=sanramon&password=sanramon");
			Statement st = con.createStatement();
			System.out.print("It is connecting");
			ResultSet rs = st.executeQuery("SELECT * FROM sanramon");
			
			while (rs.next()) {
				list.add(rs.getString("userID"));
			}
		}catch(Exception ex) {
			throw ex;
			
		}

	}

}
