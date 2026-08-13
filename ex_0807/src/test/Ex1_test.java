package test;

import java.util.Scanner;

public class Ex1_test {
  public static void main(String[] args) {
    // 윤년구하기
    // 키보드에서 년도를 입력받는다
    // 입력받은 년도가 윤년인지 평년인지를 판단

    // -------윤년--------
    // 4로 나눠떨어지지만 100으로는 나눠떨어지지 않는 연도
    // 연도가 100으로 나눠떨어지는 해는 평년
    // -> 4년 주기에 포함이 되어 있더라도 100으로 나눠지면 평년
    // 단, 100으로 나눠지더라도 400으로도 나눠지면 윤년

    // ---------------
    // 연도 : 2020
    // 2020년은 윤년입니다

    // 연도 : 2021
    // 2021년은 평년입니다

    Scanner sc = new Scanner( System.in );
    System.out.println("연도");
    

    

  }// main

}
