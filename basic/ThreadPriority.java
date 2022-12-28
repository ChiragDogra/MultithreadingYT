package basic;

class Ping implements Runnable{
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println("Ping ");
            try{Thread.sleep(300);}catch(Exception e){};
        }
    }
}

class Pong implements Runnable{
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println("Pong");
            try{Thread.sleep(300);}catch(Exception e){};
        }
    }
}


public class ThreadPriority {
    public static void main(String[] args) {
        Ping obj1 = new Ping();
        Pong obj2 = new Pong();

        Thread t1 = new Thread(obj1, "Chunnu");
        Thread t2 = new Thread(obj2, "Munnu");

        System.out.println(t1.getPriority());
        t1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(t1.getPriority());

        System.out.println(t2.getPriority());
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t2.getPriority());

        System.out.println(t1.getName());

        System.out.println(t2.getName());

        t2.start();
        t1.start();
    }
}
