package java5.threads.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class callableThread implements Callable<Integer>{
	int sum=0;
	@Override
	public Integer call() throws Exception {
		
		for(int i=0;i<3;i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> f = es.submit(new callableThread());
		Future<String> fmatch = es.submit(new callableThread().new inner());
		try {
			System.out.println(f.get());
			System.out.println(fmatch.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("done");
	}

	class inner implements Callable<String> {
		String a="2";
		String b= "3";
		@Override
		public String call() throws Exception {
			if(a.equals(b)) {
			return a+"="+b;
			}
			return a+"!="+b;
		}
	}
}
