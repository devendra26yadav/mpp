package lambda;

public class lambda1 {
    public static void main(String[] args) {
        Runnable runnable =()-> System.out.println("Running from lambda");
        runnable.run();
        //this is equivalent to

        Runnable r = new Runnable() {
            @Override
           public  void run(){
                System.out.println("Running from anonymous class");
            }
        };

        r.run();


    }
}
