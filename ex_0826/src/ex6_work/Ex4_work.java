package ex6_work;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ex4_work {
    public static void main(String[] args) {
        // Arraylist에 색상정보를 랜덤으로 10개 담기.
        // 담긴 값들 중, 내가 입력받은 문장과 동일한 값이
        // 몇 번째 index에 있는지 찾아내서 출력
        // ----------------
        // 찾을 색상 : yellow
        // [RED, BLUE, BLUE, YELLOW, RED , YELLOW ......]
        // yellow의 모든 index : [3, 5]

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        String[] str = { "RED", "GREEN", "BLUE", "YELLOW" };

        List<String> colorlist = new ArrayList<String>();
        List<Integer> resList = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            int n = rnd.nextInt(str.length);
            colorlist.add(str[n]);

        } // for

        System.out.print("찾을 문장 : ");
        String search = sc.next();

        System.out.println( colorlist );

        for( int i = 0; i < colorlist.size(); i++ ){

            if(colorlist.get(i).equalsIgnoreCase(search) ){
                resList.add(i);
            }

        }//for

        System.out.println(search + "의 모든 인덱스 : " + resList);

    }// main
}
