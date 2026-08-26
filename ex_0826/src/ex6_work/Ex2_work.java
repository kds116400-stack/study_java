package ex6_work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2_work {
    public static void main(String[] args) {

        // 다섯개의 문장을 입력받아 ArrayList에 저장하고
        // 가장 긴 문자열을 찾아 출력
        // --------------------------
        // 입력 : aaa
        // 입력 : bbbb
        // ......
        // 입력 : cccccc
        // 가장 긴 문자열 : cccccc

        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {

            System.out.print("입력 : ");
            list.add(sc.next());

        } // for

        String longer = "";

        for (int i = 0; i < list.size(); i++) {

            String str = list.get(i);

            if( str.length() > longer.length() ){
                longer = str;
            }

        } // for

        System.out.println("가장 긴 문자열 : " + longer);

    }// main
}
