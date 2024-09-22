package java1.thread_basics;

import java.util.concurrent.TimeUnit;

//MyThread implementation
public class Demo1 {
	public static void main(String[] args) {
		Tasks task = new Tasks();
		task.start();

        try {
           // Thread.sleep(3000); //milliseconds
			TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
		System.out.println("Inside main...");
    }
}

//Thread extension
 class Tasks extends Thread{
	public void run() {
		System.out.println("inside run of Task..");
		System.out.println("name of Thread: "+Thread.currentThread().getName());
		go();
	}
	private void go() {
		System.out.println("inside go.....");
		more();
	}
	private void more() {
		System.out.println("inside more.....");
	}
}
