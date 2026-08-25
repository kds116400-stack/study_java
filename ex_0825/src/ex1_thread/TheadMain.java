package ex1_thread;

public class TheadMain {
    public static void main(String[] args) {
        
        ThreadSub ts = new ThreadSub();
        ts.start();//스레드 동작

        try{
        Thread.sleep(1500);
        }catch(Exception e){

        }

        System.out.println("main스레드 종료");

    }//main
}
