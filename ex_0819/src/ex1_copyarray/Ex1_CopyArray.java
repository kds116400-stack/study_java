package ex1_copyarray;

public class Ex1_CopyArray {
    public static void main(String[] args) {
        
        //얕은복사
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        arr2[0] = 100;

        System.out.println(arr1[0]);
        System.out.println(arr2[0]);

        //깊은복사
        int[] arr3 = {1, 2, 3};
        int[] arr4 = new int[arr3.length];

        for(int i = 0; i < arr3.length; i++ ){
            arr4[i] = arr3[i];
        }

        arr3[0] = 100;

        System.out.println(arr3[0]);
        System.out.println(arr4[0]);
        

    }//main
}
