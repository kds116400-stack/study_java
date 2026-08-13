package ex3_formatter;

public class Ex1_formatter {
    public static void main(String[] args) {
        
        //저의 나이는 20살 입니다
        int age = 20;
        System.out.printf("저의 나이는 %d살 입니다\n", age);

        // 저는 20살이고 3층에 살아요
        System.out.printf("저는 %d살이고 %02d층에 살아요\n", 20,3);
    
        //나는 박씨야
        System.out.printf("나는 %c씨야\n",'박');

        //나는 a형이야
        System.out.printf("나는 %C형이야\n",'a');

        //원주율 : 3.141592
        System.out.printf("원주율: %.2f\n", 3.141592);
        
       //저는 홍길동 입니다
        System.out.printf("저는 %s 입니다\n","홍길동");

        System.out.printf("%s\t %d\t %d\n", "김윤", 100, 95);
    
        System.out.printf("%s\t %d\t %d\n", "김길동", 100, 7);

        //오늘 강수량은 15%입니다
        System.out.printf("오늘 강수량은 %d%%입니다\n",15);
    
    }//main

        
    /*
    formatter의 문법
    \n : 강제개행
    %d: 정수
    %c: 문자
    %f: 실수
    %s: 문자열
    %%: %특수문자
    */

}
