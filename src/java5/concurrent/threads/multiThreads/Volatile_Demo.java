package java5.concurrent.threads.multiThreads;

import java.util.concurrent.TimeUnit;

public class Volatile_Demo {
    //all the updates visible to all threads
    private static volatile boolean stop;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!stop)
                    System.out.println(" In while.. ");
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stop = true;
    }
}
