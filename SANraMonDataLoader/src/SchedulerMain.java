
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
public class SchedulerMain {
    


 public static void main(String[] args) {

          TimerTask task = new TimerSanRaMon("thread4");
		  Timer timer = new Timer();
		  timer.scheduleAtFixedRate(task,0, 12*60*1000);
    
}
 
 
}