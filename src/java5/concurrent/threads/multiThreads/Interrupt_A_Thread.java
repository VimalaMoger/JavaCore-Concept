package java5.concurrent.threads.multiThreads;

import java.util.concurrent.TimeUnit;

public class Interrupt_A_Thread {
    public static void main(String[] args) {
        Task task = new Task();
        task.start();

        try {
            // main thread sleeps for 3 sec
            TimeUnit.SECONDS.sleep(3);
            task.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inside main...");
    }
}

class Task extends Thread{
    public void run() {
        System.out.println("inside Task..");
        try {
            //Task thread sleeps for 9 sec
            TimeUnit.SECONDS.sleep(9);
        } catch (InterruptedException e) {
            System.out.println("Task thread got interrupted..");
        }
    }
}