package ex6_work;

import java.util.Scanner;

public class Ex4_work {
    public static void main(String[] args) {
        // 키보드에서 입력받은 두 개의 수의 최대고약수 출력
        // -------------------
        // 수1 : 18
        // 수2 : 12
        // 최대공약수 : 6

        Scanner sc = new Scanner(System.in);

        System.out.print("수1: ");
        int su1 = sc.nextInt();
        System.out.print("수2:");
        int su2 = sc.nextInt();

        if (su1 > su2) {

            int su3 = su1;
            su1 = su2;
            su2 = su3;

        } // if

        int i = su1;

        for (; i >= 1; i--) {

            if (su1 % i == 0 && su2 % i == 0) {
                break;
            }

        } // for

        System.out.println("최대공약수 : " + i);

        System.out.println("_________________");

        // 유클리드 호제법으로 최대공약수 구하기
        while (su2 != 0) {

            int tmp = su1 % su2;
            su1 = su2;
            su2 = tmp;

        } // while

        System.out.println("최대공약수 : " + su1);

    }// main
}
