package java5.concurrent.threads.multiThreads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Atomic_Operation extends Thread {
    //ID generator
     private static AtomicLong id = new AtomicLong();
    //private static long id =0;

    public static void main(String[] args) {
        Atomic_Operation thread1 = new Atomic_Operation();
        Atomic_Operation thread2 = new Atomic_Operation();
        thread1.start();
       // sleep(1);
        thread2.start();
        sleep(1);
    }

    public long getNewId(){
        return id.incrementAndGet();
        //return ++id;
    }

    @Override
    public void run(){
        System.out.println(" New ID "+ getNewId());
    }
    private static void sleep(int i){
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

