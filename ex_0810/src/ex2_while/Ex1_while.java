package ex2_while;

import java.util.Scanner;

public class Ex1_while {
    public static void main(String[] args) {

        // while문 : 간단한 구성을 가진 반복문
        // 선 비교 후 처리
        int num = 1;

        while (num <= 4) {

            System.out.println(num);
            num++;

        } // while

        System.out.println("--------------");

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("홀수 :");
            int num2 = sc.nextInt();
            System.out.println(num2);

        }

    }// main
}
