package java5.concurrent.threads.multiThreads;

import java.util.concurrent.TimeUnit;

public class Stop_Thread_Synchronized {
    //private static volatile boolean stop;
    private static boolean stop;    //using synchronized block to stop the thread
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!stop())
                    System.out.println(" In while.. ");
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // stop = true;
        requestStop();
    }

    private static synchronized void requestStop() {
        stop = true;
    }
    private static synchronized boolean stop() {
        return stop;
    }

}

