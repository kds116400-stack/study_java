package ex2_thread;

public class ThreadMain {
    public static void main(String[] args) {
        
        ThreadSub1 ts1 = new ThreadSub1();
        ThreadSub2 ts2 = new ThreadSub2();

        ts1.start();
        ts2.start();

    }//main
}
