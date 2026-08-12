package ex_work;

import java.util.Scanner;

public class Ex01_work {
    public static void main(String[] args) {

        // 입력 : 5
        // ABCDE
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        int n = sc.nextInt();

        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {

            arr[i] = (char) ('A' + i);
            System.out.print(arr[i]);

        } // for
        System.out.println();
        System.out.println("-------------");
        
        char[] cArr = new char[n];
        char ch = 'A';

        for(int i = 0; i < n; i++){

            System.out.print(cArr[i] = ch++ );
            
        }//for

    }// main
}
