package java5.threads;

class ThreadOne implements Runnable{
	String name;
	Thread t;
	ThreadOne(String name){
		this.name =name;
		t= new Thread(this, name);
	}
	@Override
	public void run() {
		System.out.println("running ");
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println("done");
	}
}

public class join_isAlive {
	
	public static void main(String [] args) {
		
		ThreadOne t1= new ThreadOne("One");
		ThreadOne t2= new ThreadOne("two");
		ThreadOne t3= new ThreadOne("three");
		t1.t.start();
		t2.t.start();
		t3.t.start();
		try{
			t1.t.join();
			t2.t.join();
			t3.t.join();
		}catch(InterruptedException e){
			System.out.println(e);
		}
		//t2.t.start();
		//t3.t.start();
	}
}
