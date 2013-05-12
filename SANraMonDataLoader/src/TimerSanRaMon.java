
import java.util.TimerTask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Rohit Erande
 */
public class TimerSanRaMon extends TimerTask{

    static String threadname;
   public TimerSanRaMon()
   {
       
   }
    
   public TimerSanRaMon(String tname)
   {
       threadname=tname;
   }
   
   private static void triggerDataLoader() throws Exception
   {
       System.out.println("called");
       //Trigger the Data Load Operation
       LoadCSVToDB rcsvldb = new LoadCSVToDB();
       rcsvldb.readDataBase();
   }
    

    @Override
    public void run() {
    	try {
			triggerDataLoader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
