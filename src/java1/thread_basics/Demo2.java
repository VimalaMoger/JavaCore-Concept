package java1.thread_basics;


//Thread implementation
class MyNewThread implements Runnable{
	Thread t;
	MyNewThread(String s){
		t = new Thread(this, s);
		System.out.println("New thread has been created:" +t);

	}

	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("i is "+ i);
		}
	}
}

public class Demo2 {

	public static void main(String[] args) {
		//Thread t = new Thread();
		MyNewThread m = new MyNewThread("Thread One");
		m.t.start();
        try {
            m.t.join(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread ...");
	}
}
