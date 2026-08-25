package ex5_work;

public class ThreadB extends Thread {
    
    private int[] arr;

    public ThreadB( int[] arr ){
        this.arr = arr;
    }

    @Override
    public void run() {

        int res = arr[0];

        for(int i = 1; i < arr.length; i++){

            res *= arr[i] ;

        }//for

        System.out.println("곱 : " + res);
    }

}
