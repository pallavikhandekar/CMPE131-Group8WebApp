
import java.util.Timer;
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
   
   private static void TimerSanRaMon()
   {
       System.out.println("called");
    // call here the code that does the insertion operation  
   }
    

    @Override
    public void run() {
       TimerSanRaMon();
    }
}
