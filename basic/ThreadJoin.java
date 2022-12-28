package basic;



public class ThreadJoin {
    public static void main(String[] args) {


        Thread t1 = new Thread(() ->{
            for(int i = 0; i<5; i++){
                System.out.println("on");
            }
        });
        Thread t2 = new Thread(() ->{
            for(int i = 0; i<5; i++){
                System.out.println("on");
            }
        });

        t1.start();
        try{t1.join(300);}catch (Exception e){};

        t2.start();
        System.out.println(t1.isAlive());
    }

}
