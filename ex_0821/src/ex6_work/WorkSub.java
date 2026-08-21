package ex6_work;

public class WorkSub {
    
    public boolean isPrime(int n){

        int i = 2;

        for(; i <= n; i++){

            if(n % i == 0)
                break;
            

        }//for

        if( i == n )
            return true;
        else
            return false;

        
    }

}
