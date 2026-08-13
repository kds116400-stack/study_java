package test;

import java.util.Scanner;

public class Ex2_test {
    public static void main(String[] args) {
        
        // 키보드에서 입력받은 2~9 사이의 값에 해당하는
        // 구구단을 출력
        // ----------------
        // 단 : 10
        // 2 ~ 9 사이의 값을 입력하세요

        // 단 : 5
        // 5*1=5
        // 5*2+10
        // ....
        // 5*9=45

    Scanner sc = new Scanner(System.in);
        System.out.println("단 :");
        int dan =sc.nextInt();

        if (dan <= 1 || dan >= 10){
            System.out.println("2 ~ 9사이의 값을 넣으세요");
        }else{

            for(int i = 1; i<=9; i++)

                System.out.printf("%d * %d = %02\n",dan , i, (dan*i));

        }




    }//main
}
