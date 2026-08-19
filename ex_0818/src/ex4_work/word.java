package ex4_work;

import java.util.Scanner;

public class word {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        // String n = sc.next();

        // 원본
        String str = sc.next();

        CheckWord cw = new CheckWord();
        String rev = cw.check( str );

        //StringBuffer sb = new StringBuffer(str);

     

        if (str.equals(rev)) { // str == rev는 String에서 거진 이용불가 (비교가 안돼서)
            System.out.println(str + "은 회문이다");
        } else {
            System.out.println(str + "은 회문이 아니다");
        }

    }//main
}
