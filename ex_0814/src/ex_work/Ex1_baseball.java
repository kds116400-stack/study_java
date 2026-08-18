package ex_work;  //사용자가 이용하는 클래스명

import java.util.Random; // 난수를 만들위해 사용되는 클래스

import java.util.Scanner; // 키보드에서 입력을 위해 사용되는 클래스

public class Ex1_baseball { // 사용자가 이용하는 패키지명
    public static void main(String[] args) {  //사용자가 사용하기 위해 사용되는 메서드범위 ( 전역범위? )

        // 세자리 수를 입력하세요(예:123) - 123
        // 1Strike, 1Ball
        // --------------------------
        // 세자리 수를 입력하세요(예:123) - 567
        // OUT!!
        // --------------------------
        // 세자리 수를 입력하세요(예:123) - 214
        // 0Strike, 3Ball
        // --------------------------
        // 세자리 수를 입력하세요(예:123) - 142
        // 4회 정답 !! - 142

        Scanner sc = new Scanner(System.in); //키보드 작성용 코드

        int[] com = new int[3];  // 맞혀야하는 코드
        int[] user = new int[3]; // 정답처리 코드

        outer: for (int i = 0; i < com.length;) { // 1차적으로 맞혀야하는 코드를 위한 for문

            com[i] = new Random().nextInt(9) + 1;  //난수를 받기위한 코드

            // 중복값 비교
            for (int j = 0; j < i; j++) { //맞혀야하는 코드의 범위

                if (com[i] == com[j]) {
                    continue outer;  // 중복값이 확인되는 코드
                }//if

            } // inner
            i++; //중복값이 중복되지 않아 내려와서 값을 찾는데 사용되는 코드

        } // outer

        System.out.println("정답 : " + com[0] + com[1] + com[2]); //맞혀야하는 코드값

        int cnt = 0; // while문의 선비교를 하기위한 값

        while (true) {  //문제의 난수를 정하기 위한 반복문

            cnt++; // while문이 반복되는 동안 난수의 값을 정하기 위한 코드

            System.out.print("입력(예:123) : "); //키보드에서 입력하여 편하게 보기위한 코드

            int number = sc.nextInt(); //키보드의 입력값?

            user[0] = number / 100;  //정답의 100자리를 표기하는 코드
            user[1] = number / 10 % 10;// 정답의 10자리를 표기하는 코드
            user[2] = number % 10;  // 정답의 1자리를 표기하는 코드

            int strike = 0;  //100, 10, 1자리 중 맞혔을때 같은 자리끼리 정답일 때 표기를 위한 코드
            int ball = 0;  //100, 10, 1자리 중 맞혔을때 같은 자리는 아니지만 정답일 때 표기를 위한 코드

            for (int i = 0; i < user.length; i++) { // 정답값 (    ) 100, 10, 1 자리값 

                for (int j = 0; j < user.length; j++) // 유저가 생각한 값 (    )100, 10, 1 자리값

                    if (i == j) {
                        if (com[i] == user[j])
                            strike++;  // 100, 10, 1자리가 맞을때 비교를 위해 나오는 코드

                    } else {
                        if (com[i] == user[j])
                            ball++;  // 100, 10 , 1 자리가 다르지만 정답에 사이에 같은 값이 있을때 나오기 위해 비교를 위한 코드
                    }

            } // for

            // 정답처리
            if (strike == 3) {
                System.out.println("정답!! - " + com[0] + com[1] + com[2]);
                System.out.println(cnt + "회 클리어");
                break;
            
                //100, 10, 1 자리가 모두 정답일때 나오는 코드

            
            }else{

                if(strike > 0 || ball > 0){
                    System.out.printf("%d strike, %d Ball\n", strike, ball);

                }else{
                    System.out.println("OUT");
                }

                //100, 10 , 1자리가 중 자리는 같거나 틀렸을때 나오는 코드

            }

            System.out.println("---------------");

        } // while

    }// main
}
