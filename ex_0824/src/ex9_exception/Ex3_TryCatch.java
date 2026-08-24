package ex9_exception;

public class Ex3_TryCatch {
    public static void main(String[] args) {
        
        try{
        
        int[] arr = {10, 20, 30};

        for(int i = 0; i <= arr.length; i++ ){  //<= 기호가 에러상황
            System.out.println(arr[i]);         //수정이 가능하나 사용자가 
                                                // 못잡거나 귀찮아서 사용하면 안된다
        }//for

        }catch (Exception e){

        }

        System.out.println("프로그램 끝");

    }//main
}
