package ex1_copyarray;

public class ArrMain {
    public static void main(String[] args) {
        
        int[] array = {1, 2, 3, 4, 5};

        ArrSub as = new ArrSub();
        as.param(array);

        System.out.println("main : " + array[0]);

    }//main
}
