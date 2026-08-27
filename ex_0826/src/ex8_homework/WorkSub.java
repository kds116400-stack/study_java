package ex8_homework;

import java.util.List;
import java.util.Random;

public class WorkSub extends Thread{
    
    private List<String> arr;
    private String[] data;
    private Random rnd;

    public WorkSub( List<String> arr, String[] data ){
        this.arr = arr;
        this.data = data;
        rnd = new Random();
    }

    @Override
    public void run() {
     
        while (true) {

            int random = rnd.nextInt(data.length);
            arr.add( data[random] );

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            
        }

    }

}
