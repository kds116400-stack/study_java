package ex7_filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ex3_bufReader {
    public static void main(String[] args) {
        
        String path = "C:/myFile/work3.txt";
        File f = new File(path);

        FileReader fr = null;
        BufferedReader br = null;

        try {
            
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String msg;

            //BufferedReadder가 줄 단위로 내용을 읽어온다
            while( (msg = br.readLine()) != null) {

                System.out.println(msg);
                
            }//while

        } catch (Exception e) {
            // TODO: handle exception
        } finally{

            try {
                
                if( br != null ){
                   br.close();
                }
                if( fr != null ){
                    fr.close();
                 }


            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }//main
}
