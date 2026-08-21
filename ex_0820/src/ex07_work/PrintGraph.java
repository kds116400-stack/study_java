package ex07_work;

public class PrintGraph {
    
    public void print(int[] arr){

        for(int i = 0; i < arr.length; i++){

            System.out.println(i + "의 갯수 : ");

            for(int j = 0; j < arr[i]; j++){

                System.out.print("#");

            }//inner

            System.out.println(" " + arr[i]);

        }//outer

    }

}
