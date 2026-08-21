package ex7_work;

public class WorkMain {
    public static void main(String[] args) {

        // 가장 큰 값 : 20
        int[] arr = { 1, 11, 7, 20, 31, 15 };

        WorkSub ws = new WorkSub();
       // ws.getBigger(arr);
        int res = ws.getBigger(arr);

        System.out.println("가장 큰 값 : " + res);

        // int max = 0;

        // for(int i = 0; i < arr.length; i++){

        // if( i <= max ){

        // }

        // }//for

    }// main
}
