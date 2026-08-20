package ex7_work;

import java.util.Random;

public class Updownsub {

    private int random = new Random().nextInt(50) + 1;
    private int count = 0;
    private boolean result = true;

    // 정답판별 메서드
    public boolean check(int n){

        count++;

        if( n < random )
            System.out.println("UP");

        else if(n > random)
            System.out.println("DOWN");

        else{
            System.out.println(count + "회 만에 정답");
            result = false;
        }

        return result;

    }// check()
}
