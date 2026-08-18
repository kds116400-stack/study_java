package ex_work;

import java.util.Scanner;

public class Ex1_work {
    public static void main(String[] args) {
        
        //키보드에서 입력받은 값이 회문인지 판다
        //------------------
        //입력 : abcba
        //abcba은(는) 회문입니다

        //입력 : abc
        //abc은(는) 회문이 아닙니다

        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        String n = sc.next();

        for(int i = 0; i < n.length(); i++){

            String str = "";
            
           while(true){

                char ch = str.charAt(i);

                if( ch == '0' || ch == '9' ){
                    break;
                }
                

            }//while

            i++;

            if(  i == str.length() ){
                System.out.println("은(는) 회문입니다");
            }else{
                System.out.println("은(는) 회문이 아닙니다");
            }

        }//for

    }//main
}
