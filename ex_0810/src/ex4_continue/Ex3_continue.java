package ex4_continue;

public class Ex3_continue {
    public static void main(String[] args) {
        
        int n = 0;

        while( n < 10){
            n++;
            
            if( n % 2 ==0){
                continue;
            }

            System.out.println(n);
        }

    }//main
}
