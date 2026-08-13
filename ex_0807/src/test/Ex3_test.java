package test;

import java.util.Random;
import java.util.Scanner;

public class Ex3_test {
    public static void main(String[] args) {
        
        // A ~ Z 사이의 값중 하나를 랜덤으로 출력

        Scanner sc = new Scanner( System.in );
        int rnd = new Random().nextInt('Z'-'A'+1) +'A';
        System.out.println((char)rnd);
        

    }//main
}
