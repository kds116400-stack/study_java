package ex4_work;

public class ThreadSub extends Thread {
    
    private int num;
    public ThreadSub(int num){
        this.num = num;
    }

    @Override
    public void run() {

        for(int i = num; i >= 0; i--){

            try{
                System.out.println(i);
                Thread.sleep(1000);
            } catch(Exception e){
                //TODO

            }

        }//for
        


        
        
    }

}
