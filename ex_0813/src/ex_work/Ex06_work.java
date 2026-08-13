package ex_work;

import java.util.Scanner;

public class Ex06_work {
    public static void main(String[] args) {
        //등록할 인원수 : 2
        //이름 : 홍길동
        //수학 : 99
        //영어 : 100
        //국어 : 75
        //_---------------
        //이름 :김길순
        //수학 : 70
        //영어 : 89
        //국어 : 99
        //-------------------
        // 총 2명의 학생 정보가 등록됨
        //[ 학생 등록정보]
        // 홍길동   99   100  75 
        // 김길순   70   89   99
        Scanner sc =new Scanner(System.in);
        System.out.println("등록할 인원수 : ");
        int n = sc.nextInt();
        
        String[] info = {"이름 : ", "수학 : ", "영어 : ", "국어 : "};
        String[][] str = new String[n][info.length];
       // for(int i = 0; i < str.length; i++){
            

            // System.out.print("이름 : ");
            //str[i][0] = sc.next();

           // System.out.println("수학 : ");
            //str[i][1] = sc.next();

            //System.out.println("영어 : ");
            //str[i][2] = sc.next();

           // System.out.println("국어 : ");
           // str[i][2] = sc.next();

          //  System.out.println(-------------);
           
        //}//for
        
        //학생정보 등록
        for (int i = 0; i< str.length; i++){

            for(int j = 0; j < str[i].length; j++){

                System.out.println(info[j]);
                str[i][j] = sc.next();
                
            }//inner

            System.out.println("--------------");

        }//outrt

        System.out.printf("총 %d명의 정보가 등록됨\n",n);
        System.out.println("[학생 등록정보]");

        for(int i = 0; i< str.length; i++){

            for(int j=0; j<str[i].length; j++){
                System.out.printf("%s\t", str[i][j]);
            }//inner

            System.out.println();

        }//outer

            


    }//main


}
