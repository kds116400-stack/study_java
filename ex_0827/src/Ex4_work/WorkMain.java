package ex4_work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class WorkMain {
    public static void main(String[] args) throws IOException {
        
        //C:/myFile/work3.txt에서
        //사용자가 입력받은 값의 출현 빈도를 출력
        //-----------------
        //입력 : 홍
        //홍의 출현 횟수 : 4

        Scanner sc = new Scanner(System.in);
        String path = "C:/myFile/work3.txt";
        File f = new File(path);

        byte[] read = new byte[(int)f.length()];
        FileInputStream fis = null;

        int count = 0;

        try {
            
            fis = new FileInputStream(f);
            fis.read( read );
            String coutrnt = new String(read );

            System.out.print("입력 : ");
            String input = sc.next(); 

            char s = input.charAt(0);

            for(int i = 0; i < coutrnt.length(); i++){

                if(s == coutrnt.charAt(i)){
                    count++;
                }

            }//for

            System.out.printf("%c의 갯수 : %d개\n", s, count);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        
        }finally {
            
            if(fis != null)
            fis.close();
        }

    }//main
}
