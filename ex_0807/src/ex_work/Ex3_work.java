package ex_work;

import java.util.Random;

public class Ex3_work {
    public static void main(String[] args) {
        
        // A ~ Z 사이의 값중 하나를 랜덤으로 출력
        //int rnd = new Random().nextInt(90 - 65 +1 ) + 65;

        int rnd = new Random().nextInt('Z' - 'A' + 1 ) + 'A';
        System.out.println((char)rnd);
        
        
    }//main
}
