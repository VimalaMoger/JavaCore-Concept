package java5.concurrent.threads.multiThreads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Meet_Up_Event {
    private static  String name;
    private AtomicInteger count = new AtomicInteger(1);//1 for organizer

    public Meet_Up_Event(String name){
        this.name = name;
    }
    public void attending(int guestCount){
        if(guestCount == 1)
            count.incrementAndGet();
        else
            count.addAndGet(guestCount);
    }

    public void notAttending(int guestCount){
        if(guestCount == 1)
            count.decrementAndGet();
        else {
            boolean updated = false;
            while(!updated){
                int currentCount = count.get();
                int newCount = currentCount - guestCount;
                updated = count.compareAndSet(currentCount,newCount);
            }
        }
    }
    public int getCount(){
        return  count.get();
    }

    public static void main(String[] args) {
        Meet_Up_Event event = new Meet_Up_Event("group1");
        Thread user1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                event.attending(4);
                System.out.println(Thread.currentThread().getName() + " guestCount "+event.getCount());
            }
        });
        Thread user2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                event.attending(1);
                System.out.println(Thread.currentThread().getName() + " guestCount "+event.getCount());
            }
        });
        Thread user3 =  new Thread(new Runnable() {
            @Override
            public void run() {
                event.attending(3);
                System.out.println(Thread.currentThread().getName() + " guestCount "+event.getCount());
                event.notAttending(3);
                System.out.println(Thread.currentThread().getName() + " guestCount "+event.getCount());
            }
        });

        user1.start();
        sleep(1);
        user2.start();
        sleep(2);
        user3.start();
        sleep(3);
        System.out.println("Total attending "+ event.getCount());

    }
    private static void sleep(int i){
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
