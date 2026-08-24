package ex10_work;

import java.util.Scanner;

public class Ex1_work {
    public static void main(String[] args) {
        
        //정수 :  123
        //입력받은 수 : 123

        //정수 : abc
        //정수만 입력할 수 있습니다.
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 : ");
        
        try{
        int n = sc.nextInt();
        System.out.println("입력받은 수 :" + n);
        
        }catch ( Exception e ){
            System.out.println("정수만 입력가능");
            
        }

       



    }//main
}
