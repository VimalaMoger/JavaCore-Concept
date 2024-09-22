package java5.concurrent.threads.multiThreads.ProducerConsumer;

class Q{
	int val;
	boolean rest = false;
	
	synchronized int get() {
		while(!rest) {
			try{
				wait();
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
			System.out.println(Thread.currentThread().getName()+ " Consuming value of n: " + val);
			notify();
			rest = false;
			return val;
	}

	synchronized void put(int n) {
		while(rest) {
			try{
				wait();
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		this.val =n;
		System.out.println(Thread.currentThread().getName() + " Producing value of n: " +n);
		notify();   //notifies consumer
		rest = true;
	}
}

class Producer implements Runnable{
	Thread t;
	Q q;
	Producer(Q q){
		this.q= q;
		t = new Thread(this, " Producer Thread ");
	}
	public void run() {
	/*	int newValue= 0;
		while(true) {
			q.put(newValue++);
		}*/
		for(int i = 0; i< 5;i++){
			q.put(i);
		}
	}
}

class Consumer implements Runnable{
	Thread t;
	Q q;
	Consumer(Q q){
		this.q= q;
		t = new Thread(this, " Consumer Thread ");
	}
	public void run() {
		while(true) {
			q.get();
		}
	}
}

public class waitNotifyThread {
	public static void main(String[] args) {
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		p.t.start();
		c.t.start();
	}

}
