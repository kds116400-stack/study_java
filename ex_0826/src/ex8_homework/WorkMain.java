package ex8_homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkMain {
    public static void main(String[] args) {
        /*
         * [strawberry]
         * >> strawberry
         * [orange, grape, apple]
         * >> orange
         * [grape, apple]
         * >> grape
         * [apple, apple]
         * >> apple
         * [apple]
         * >> apple
         * [strawberry]
         * >> strawberry
         * 클리어!!!
         */
        
        String[] data = {"apple", "banana", "grape", "strawberry", "pineapple"};
        List<String> arr = new ArrayList<String>();

        WorkSub ws = new WorkSub(arr, data);
        ws.setDaemon(true);
        ws.start();

       Scanner sc = new Scanner(System.in);

        while (true) {

            if( arr.size() == 0 ){
                System.out.println("클리어!!!");
                break;
            }

            System.out.println(arr);
            System.out.println(">>");
            String in = sc.next();

            //사용자가 입력한 단어와 arr에 담긴 값을 비교
            for( int i = 0; i < arr.size(); i++ ){

                if(in.equals(arr.get(i))){
                    arr.remove(i);
                    break;
                }

            }//for
            
        }//while

    }//main
}
