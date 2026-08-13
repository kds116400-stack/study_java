package ex2_random;

import java.util.Random;

public class Ex1_random {
    public static void main(String[] args) {

        //216 ~ 1378사이의 난수
        //new Random().nextInt(난수의 범위) + 시작 수
        //new Random().nextInt(큰 수 - 작은 수 +1) + 시작 수
        //int num = new Random().nextInt( 7 ) + 7;

        int num = new Random().nextInt( 1378- 216 +1) +216;

        System.out.println( num );

        // 2 ~ 9  사이의 난수에 해당하는 구구단
        
        int dan = new Random().nextInt(8 ) + 2;
        
        for( int i = 1; i <= 9; i++ ){
           System.out.println(dan + " * " + i + " = " + ( dan * i) );
        }



    }// main
}
