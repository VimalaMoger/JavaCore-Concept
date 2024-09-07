package java8.functionalProgExample;

import java.util.Timer;
import java.util.TimerTask;
	
class DoWork extends TimerTask{

		@Override
		public void run() {
			System.out.println("Do all the work");
			System.out.println("end of task");
		}
	}

public class TimerTasksTest {
	public static void main(String[] args) {
		
		DoWork f = new DoWork();
		Timer t  = new Timer();
		t.schedule(f,5000);
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.getStackTrace();
		}
		t.cancel();  //otherwise will still run in console
	}
}
