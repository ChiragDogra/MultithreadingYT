package basic;

class A{

        }

class One extends Thread{

    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("one");
            try {
                Thread.sleep(500);
            }catch(Exception e){};
        }
    }
}

class Zero extends Thread{

    @Override
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println("zero");
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){}
        }
    }
}


public class ThreadByClass {
    public static void main(String[] args){
        One obj1 = new One();
        Zero obj2 = new Zero();

        obj1.start();
        obj2.start();
    }
}
