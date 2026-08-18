package ex_work;

import java.util.Scanner;

public class Ex4_work {
    public static void main(String[] args) {
        
        //키보드에서 입력받은 ox값을 계산하여 출력하기
        //--------------
        //입력 : ooxxo
        //결과 : 4

        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        String qu = sc.next();

        int cnt = 0;
        int sum = 0;
        
        for(int i = 0; i < qu.length(); i++){

            if( qu.charAt(i) == 'o' ){
                cnt++;
            }else{
                cnt = 0;
            }
            sum += cnt;
            
        }//for

        System.out.println("결과 : " + sum);

        
        
        
    }//main
}
