package interThreadComm;

class X{
    int num;
    boolean valueSet = false;
    public synchronized void set(int num){
        while(valueSet){
            try{wait();}catch (Exception e){};
        }
        this.num = num;
        System.out.println("Set: " + this.num);
        valueSet = true;
        notify();
    }

    public synchronized void get(){
        while (!valueSet){
            try{wait();}catch (Exception e){};
        }
        System.out.println("Get: " + this.num);
        valueSet = false;
        notify();
    }
}


class Producer implements Runnable{
    X x;

    Producer(X x){
        this.x = x;
        Thread t = new Thread(this, "Producer Thread");
        t.start();
    }

    int i = 0;
    public void run(){
        while (true){
            x.set(i++);
            try{Thread.sleep(100);}catch (Exception e){};
        }
    }
}

class Consumer implements Runnable{
    X x;

    Consumer(X x){
        this.x = x;
        Thread t = new Thread(this, "Producer Thread");
        t.start();
    }


    public void run(){
        while (true){
            x.get();
            try{Thread.sleep(3000);}catch (Exception e){};
        }
    }
}


public class ProducerConsumer{
    public static void main(String[] args) {
        X obj = new X();

        new Producer(obj);
        new Consumer(obj);
    }
}
