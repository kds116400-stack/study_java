package ex4_work;

public class Gugudan {
    
    //구구단을 출력하는 메서드
    public void printgugu( int dan ){

        System.out.println(dan + "단");
       
        for(int i = 1; i <= 9; i++){
            System.out.printf("%d x %d =%d\n", dan , i, (dan * i));
        }//for



    }
   

}
