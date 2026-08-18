package ex_work;

import java.util.Scanner;

public class Ex5_work {
    public static void main(String[] args) {
        
        //문장 : HelloWorld
        //결과 : Hlool

        Scanner sc =new Scanner(System.in);
        System.out.print("문장 : ");
        String in = sc.next();

        String res = "";

        for(int i = 0; i < in.length(); i+=2){

            res += in.charAt(i);
            
        }//for

        System.out.println(res);

        // for(int i = 0; i < in.length(); i++){

        //     if( i % 2 == 0 ){
        //         System.out.print( str.charAt(i));
        //     }

        //}//for

    }//main
}
