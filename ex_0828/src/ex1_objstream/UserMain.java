package ex1_objstream;

import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User user = new User();

        System.out.println("1.새로등록");
        System.out.println("2.불러오기");
        System.out.print(">>");

        int sel = sc.nextInt();

        switch (sel) {

            case 1:// 유저등록
                System.out.print("이름 : ");
                user.setName(sc.next() );

                System.out.print("나이 : ");
                user.setAge(sc.nextInt() );

                System.out.print("전화 : ");
                user.setTel(sc.next() );

                UserWriter uw = new UserWriter();
                uw.writeInfo(user);
                break;

            case 2:// 불러오기
                System.out.print("전화 : ");
                String tel = sc.next();

                UserLoader u1 = new UserLoader();
                user = u1.loadInfo(tel);

                if(user != null){
                System.out.println("이름 : " + user.getName() );
                System.out.println("나이 : " + user.getAge() );
                System.out.println("전화 : " + user.getTel() );
                }
                break;

            default:
                break;
       
            }//switch

    }// main
}
