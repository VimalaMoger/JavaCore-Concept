package java5.threads;

//suspend and resume a thread

class MyThread2 implements Runnable{
	Thread t;
	boolean suspendThread ;
	
	MyThread2(String s){
		t = new Thread(this, s);
		System.out.println("New thread has been created:" +t);
		suspendThread= false;
	}
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			try{
				Thread.sleep(1000);
				System.out.println(i);
				synchronized(this) {  		//synchronized block
					while(suspendThread) {
						System.out.println("pausing thread");
						wait();
					}
				}
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
	synchronized void suspendT() {
		suspendThread=true;
	}
	synchronized void resumeT() {
		suspendThread=false;
		notify();
		System.out.println("resuming thread");
	}
}

//suspend, resume, stop methods found in old version of java
public class SuspendThread {

	public static void main(String[] args) {
		//Thread t = new Thread();
		MyThread2 m = new MyThread2("Thread One");
		m.t.start();
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			System.out.println(e);
		}
		m.suspendT();
	}
}