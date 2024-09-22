package java1.thread_basics;

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
				synchronized(this) {        //synchronized block
					if (suspendThread) {
						System.out.println(Thread.currentThread().getName() + " paused ");
						wait();
					}
				}
				suspendThread();
			}catch(InterruptedException e){
				System.out.println(e);
			}
			//resumeT();
		}

	}

	synchronized void suspendThread() {
			suspendThread = true;
	}

/*	synchronized void resumeT () {
			suspendThread = false;
			System.out.println(Thread.currentThread().getName() + " notified ");
			notify();
	}*/
}

public class Suspend_Thread {

	public static void main(String[] args) {
		//Thread t = new Thread();
		MyThread2 m = new MyThread2("Thread One");
		m.t.start();

		//main thread sleeps about 5secs
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			System.out.println(e);
		}
	}
}