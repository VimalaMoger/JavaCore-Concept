package java5.threads.ProducerConsumerProblem;

class Q{
	int n;
	boolean rest = false;
	
	synchronized int get() {
		while(!rest) {
			try{
				wait();
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
			System.out.println("Consuming value of n: " + n);
			notify();
			rest = false;
			return n;
	}

	synchronized void put(int n) {
		while(rest) {
			try{
				wait();
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		this.n =n;
		System.out.println("Producing value of n: " +n);
		notify();   //notifies consumer
		rest = true;
	}
}

class Producer implements Runnable{
	Thread t;
	Q q;
	Producer(Q q){
		this.q= q;
		t = new Thread(this, "Producer Thread");
	}
	public void run() {
		int i= 0;
		while(true) {
			q.put(i++);
		}
	}
}

class Consumer implements Runnable{
	Thread t;
	Q q;
	Consumer(Q q){
		this.q= q;
		t = new Thread(this, "Consumer Thread");
	}
	public void run() {
		while(true) {
			q.get();;
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
