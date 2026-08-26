package ex2_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex3_Map {
    public static void main(String[] args) {

        //id : abc
        //pw : 1111
        //id가 존재하지 않습니다

        //id : kin
        //pw : 2222
        //비밀번호 불일치

        //id : lee
        //pw : 2222
        //로그인 성공

        Scanner sc = new Scanner(System.in);
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("kim", 1111);
        map.put("lee", 2222);

       System.out.print("id : ");
       String id = sc.next();

       System.out.print("pw : ");
       int pwd = sc.nextInt();

       if( !map.containsKey(id) ){
            System.out.println("아이디가 존재하지 않음");
       
        }else{
            if(map.get(id) == pwd ){
                System.out.println("로그린 성공");
            }else{
                System.out.println("비밀번호 불일치");
            }

        }


    }//main
}
