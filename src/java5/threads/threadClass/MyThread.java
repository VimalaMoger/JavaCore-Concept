package java5.threads.threadClass;

//MyThread implementation
public class MyThread extends Thread{
	public void run() {
		System.out.println("inside run of myThread..");
		System.out.println("name of Thread: "+Thread.currentThread().getName());
		go();
		
	}
	private void go() {
		System.out.println("inside go.myThread..");
		more();
	}
	private void more() {
		System.out.println("inside more.Mythread..");
	}
}
