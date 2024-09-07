package java8.functionalProgExample;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask  extends TimerTask{
	
	@Override
	public void run() {
		System.out.println("Task started");
	}

	public static void main(String[] args) {
		MyTimerTask task = new MyTimerTask();
		Timer time = new Timer();
		time.schedule(task, 1000, 500);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		time.cancel();
	}
}
