package ex5_work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkMain {
    public static void main(String[] args) {

        // id : aaa
        // pw : 1111
        // aaa/1111
        // ---------------
        // id : bbb
        // pw : 2222
        // aaa/1111
        // bbb/2222
        // -----------
        // id : bbb
        // pw : 1111
        // 아이디가 중복됩니다
        // --------------
        // id :

        Scanner sc = new Scanner(System.in);

        List<User> list = new ArrayList<User>();

       outer: while (true) {

            System.out.print("id : ");
            String id = sc.next();

            System.out.println("pw : ");
            int pwd = sc.nextInt();

            User us = new User();
            us.setId(id);
            us.setPw(pwd);


            //중복체크
             for(int i = 0; i < list.size(); i++){

                if( list.get(i).getId().equals(id) ){
                    System.out.println("아이디가 중복됩니다");
                    continue outer;
                }
            

            }//for

            list.add(us);

            for (int i = 0; i < list.size(); i++) {

                System.out.println(list.get(i).getId() + "/" +
                        list.get(i).getPw());

            } // for

            System.out.println("--------");

        } // while

    }// main
}
