package ex_work;

import java.util.Scanner;

public class Ex1_work {
    public static void main(String[] args) {

        // 키보드에서 입력받은 값이 회문인지 판다
        // ------------------
        // 입력 : abcba
        // abcba은(는) 회문입니다

        // 입력 : abc
        // abc은(는) 회문이 아닙니다

        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        // String n = sc.next();

        // 원본
        String str = sc.next();

        StringBuffer sb = new StringBuffer(str);

        // 원본을 뒤집어서 저장할 객체
        String rev = sb.reverse().toString();

        // for (int i = str.length() - 1; i >= 0; i--) {

        // rev += str.charAt(i);

        // } // for

        if (str.equals(rev)) { // str == rev는 String에서 거진 이용불가 (비교가 안돼서)
            System.out.println(str + "은 회문이다");
        } else {
            System.out.println(str + "은 회문이 아니다");
        }

    }// main
}
