package ex3_runnable;

public class ThreadMain {
    public static void main(String[] args) {
        
        ThreadSub ts = new ThreadSub();
        Thread t = new Thread(ts);

        t.start();

    }//main
}
