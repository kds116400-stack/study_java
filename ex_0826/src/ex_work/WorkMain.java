package ex_work;

import java.util.Random;
import java.util.Scanner;

public class WorkMain {
    public static void main(String[] args) {
        
        //1 ~ 100사이의 난수 두개를 더하는 문제 출제
        //카보드에서 답을 입력하여 다섯문제가 정답처리 될 때까지 로직을 반복
        //5문제를 모두 맞힐때까지 몇 초가 걸렸는지를 출력하며 종료
        //1) 사용자가 문제의 정답으로 정수 이외의 값을 입력했다면
        //'정답은 정수로 입력하세요'라는 오류메시지 출력
        //2)데몬스레드는 사용하지 않는다
        //------------------
        //23 + 48 = 71
        //정답입니다
        //22 + 100 = 100
        //오답입니다
        //.....
        //50 + 15 = 65
        //정답입니다
        //결과 : 24초
        
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int playCount = 0;
        final int FINISH = 3;

        TimerSub ts = new TimerSub();
        ts.start();//타이머 시작

        while (true) {
            
            if( playCount == FINISH ){
                ts. setCheck(false);
                break;
           
            }else{

                
                try{

                    int su1 = rnd.nextInt(100) + 1;
                    int su2 = rnd.nextInt(100) + 1;
                    System.out.printf(
                        "%d + %d = ", su1, su2);

                    int res = sc.nextInt();

                    if(res == su1 + su2){
                        System.out.println("정답입니다");
                        playCount++;
                    }else{
                        System.out.println("오답입니다");
                    }

                    
                }catch(Exception e){

                    System.out.println("정답은 정수로 입력해야 합니다");
                    
                }
            }

        }//while



    }//main
}
