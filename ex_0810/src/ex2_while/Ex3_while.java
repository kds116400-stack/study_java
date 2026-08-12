package ex2_while;

import java.util.Random;
import java.util.Scanner;

public class Ex3_while {
    public static void main(String[] args) {

        // 1~100사이의 난수를 만들고
        // 키보드에서 입력받은 값이 정답일 떄 게임을 종료
        // ----------------
        // 숫자 : 25
        // up
        // 숫자 : 70
        // down
        // 숫자 : 50
        // 정답입니다

        Scanner sc = new Scanner(System.in);


        // 사용자가 맞혀야 할 정답
        int answer = new Random().nextInt(100 - 1) + 1;
        int num = 0; // 사용자가 입력할 값

        while (num != answer) {

            System.out.print("숫자 : ");
            num = sc.nextInt();
            System.out.println("값: " + num);

            if( num < answer){
                System.out.println("UP");
            }else if(num >answer){
                System.out.println("DOWN");
            }else{
                System.out.println("정답");
            }

            

        } // while

    }// main
}
