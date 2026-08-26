package ex6_work;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex1_work {
    public static void main(String[] args) {
        
        //Arraylist arr에 1 ~ 30사이의 난수를 5개 추가
        //arr에 담겨진 값 중 가장 큰 값 출력
        //------------------
        //[16, 13, 29, 29 ,14]
        //가장 큰 값 : 29
        List<Integer> arr = new ArrayList<Integer>();
        Random rnd = new Random();
               
        for(int i = 0; i < 5; i++){
            int n = rnd.nextInt(30) + 1 ;
            arr.add(n);
        }
        System.out.println(arr);

        int max = arr.get(0);

        for(int i = 1; i < arr.size(); i++){

            if(arr.get(i) > max){
                max = arr.get(i);
            }

        }//for
        System.out.println("가장 큰 값 : " + max);
    }//main
}
