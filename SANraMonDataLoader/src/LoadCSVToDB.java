
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import au.com.bytecode.opencsv.CSVReader;


/***
 * Reads CSV and Loads MYSQL database.
 * PRE_REQ: RUN SCRIPT "DATABASE_SCRIPT.sql" on your local mysql instance.
 * @author Sakshi and Pallavi
 *
 */
public class LoadCSVToDB {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      
      // Setup the connection with the DB
      // This assumes that we have database of name sanramon and there is a user
      // sanramon having the password sanramon who has all the privileges
      // to insert the data
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/sanramon?"
              + "user=sanramon&password=sanramon");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
     
      loadConfigurationData();
      loadMonitoringData();
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

  
  private void loadConfigurationData() throws IOException, SQLException
  {
	  String csvFilename = "./../datafiles/Sample_Org_Data_1.csv";
      CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
      String[] row = null;
      while((row = csvReader.readNext()) != null) {
      
   
          // PreparedStatements can use variables and are more efficient
          // It assumes a table of name sanramon_users having following columns:
          // (Company, Department, UserID, User,IPAddress, LUN, IOChannel);
          preparedStatement = connect.prepareStatement("insert into sanramon.sanramon_users values (?, ?, ?, ?, ? , ?, ?)");
      
          preparedStatement.setString(1, row[0]);
          preparedStatement.setString(2, row[1]);
          preparedStatement.setString(3, row[2]);
          preparedStatement.setString(4, row[3]);
          preparedStatement.setString(5, row[4]);
          preparedStatement.setString(6, row[5]);
          preparedStatement.setString(7, row[6]);
          preparedStatement.executeUpdate();
      }
       
      csvReader.close();
   
  }
  
  private void loadMonitoringData() throws IOException, SQLException
  {
	  String rootDirectory = System.getProperty("user.dir");
	  String csvFilename = rootDirectory + "/datafiles/SANData-111485.csv";
      CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
      String[] row = null;
      while((row = csvReader.readNext()) != null) {
      
   
          // PreparedStatements can use variables and are more efficient
          // It assumes a table of name sanramon_users having following columns:
          //  "IO_TYPE","IO_CHANNEL", "LUN", "MON_TIMESTAMP", "IP_ADDR", "NO_OF_DATABLOCKS","DURATION" ,"IOPS"
          preparedStatement = connect.prepareStatement("insert into sanramon.monitor_data values (?, ?, ?, ?, ? , ?, ?,?)");
      
          preparedStatement.setString(1, row[0]);
          preparedStatement.setString(2, row[1]);
          preparedStatement.setString(3, row[2]);
          preparedStatement.setString(4, row[3]);
          preparedStatement.setString(5, row[4]);
          preparedStatement.setString(6, row[5]);
          preparedStatement.setString(7, row[6]);
          preparedStatement.setString(8, row[7]);
          preparedStatement.executeUpdate();
      }
       
      csvReader.close();
   
  }
} 