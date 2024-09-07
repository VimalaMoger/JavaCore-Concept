package java5.threads.runnable;

class MyThread implements Runnable{
	Thread t;

	
	MyThread(String s){
		t = new Thread(this, s);
		System.out.println("New thread has been created:" +t);
	}

	public void run() {
		for(int i=0;i<5;i++) {
			try{
				Thread.sleep(1000);
				System.out.println(i);
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
}

//suspend, resume, stop methods found in old version of java
public class NewThread {

	public static void main(String[] args) {
		//Thread t = new Thread();
		MyThread m = new MyThread("Thread One");
		m.t.start();
	}
}
