package ex6_work;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ex3_work {
    public static void main(String[] args) {

        // 정수입력( 입력종료 : 0 )
        // >> 45
        // >> 17
        // >> 20
        // >> 21
        // >> 0
        // --------------------
        // 숫자 범위를 입력하세요
        // 시작수 : 15
        // 끝 수 : 20
        // 17
        // 20

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();

        System.out.println("정수입력(종료 : 0)");

        while (true) {

            System.out.print(">> ");
            int num = sc.nextInt();

            if (num == 0) {
                break;
            }

            list.add(num);

        }//while

        System.out.println("-------------");

        System.out.print("시작수 : ");
        int start = sc.nextInt();

        System.out.print("끝 수  : ");
        int end = sc.nextInt();

        System.out.println("--------------");

        for(int i = 0; i < list.size(); i++){

            if(list.get(i) >= start && list.get(i) <= end)
                System.out.println(list.get(i) + " ");
        }//for

    }// main
}
