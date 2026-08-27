package ex2_fileinput;

import java.util.Scanner;

public class Ex3_input {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        byte[] console = new byte[100];
        
        //sc.close();
        try {
            
         System.out.print("입력 : ");
         System.in.read(console);

         String res = new String( console );
         System.out.println(res.trim()); 
         
         //System.in.close();



        } catch (Exception e) {
            // TODO: handle exception
        }

    }//main
}
