package ex03_work;

import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        /*
         * 1.입 금
         * 2.출 금
         * 3.잔액확인
         * ect.종 료
         * >> 1
         * ---입 금---
         * 입금액 : 1000
         * 입금성공
         * ------------
         * 1.입 금
         * 2.출 금
         * 3.잔액확인
         * ect.종 료
         * >> 3
         * ---잔액확인---
         * 1000원
         * -------------
         * 1.입 금
         * 2.출 금
         * 3.잔액확인
         * ect.종 료
         * >> 4
         * atm 사용을 종료합니다
         */

        Scanner sc = new Scanner(System.in);
        Atm atm = new Atm();
      

        while (true) {

            System.out.println("1.입 금");
            System.out.println("2.출 금");
            System.out.println("3.잔 액");
            System.out.println("ect.종료");
            System.err.println(">>");

            int select = sc.nextInt();
            int money = 0;
            

            switch (select) {

                case 1:
                    System.out.println("-------입금-------");
                    System.out.println("입금 : ");
                    money = sc.nextInt();
                    atm.deposit(money);
                    break;

                case 2:
                    System.out.println("---------출금-----");
                    System.out.println("출금액 : ");
                    money = sc.nextInt();
                    atm.withdraw(money);
                    break;

                case 3:
                    System.out.println("-----잔액확인-----");
                    atm.balance();
                    break;

                default:
                    System.out.println("atm 사용을 종료합니다");
                    return;

            }// swich

            System.out.println("-------------");

        } // while

    }// main
}
