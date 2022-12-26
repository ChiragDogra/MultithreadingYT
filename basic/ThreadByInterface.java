package basic;

class On implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println("on");
            try {
                Thread.sleep(300);
            }
            catch (Exception e){};
        }
    }
}

class Off implements Runnable{
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println("off");
            try{
                Thread.sleep(300);
            }
            catch (Exception e){};
        }
    }
}

public class ThreadByInterface {
    public static void main(String[] args) {
        On obj1 = new On();
        Off obj2 = new Off();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}
