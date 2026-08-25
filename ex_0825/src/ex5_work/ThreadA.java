package ex5_work;

public class ThreadA extends Thread {
    
    private int[] arr;

    public ThreadA(int[] arr){
        this.arr = arr;
    }

    @Override
    public void run() {
        
      

        int res = 0;
        
        for(int i = 0; i < arr.length; i++){

            res += arr[i];

        }//for

        System.out.println("합 : " + res);

    }

}
