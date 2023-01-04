package threadSafety;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Counter{
    AtomicInteger count = new AtomicInteger();


    public void increase(){
//        count++; //count = count+1
        count.addAndGet(1);
    }
}


public class RaceCondition {
    public static void main(String[] args) {
        Counter obj = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i<1000; i++){
                    obj.increase();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i<1000; i++){
                    obj.increase();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        }catch (Exception e){};
        try {
            t2.join();
        }catch (Exception e){};

        System.out.println(obj.count);
    }
}
