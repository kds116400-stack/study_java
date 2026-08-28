package ex8_fileWriter;

import java.io.File;
import java.io.FileWriter;

public class Ex1_FileWriter {
public static void main(String[] args) {
    
    String path = "C:/myFile/Writer예제.txt";
    File f = new File(path);
    FileWriter fw = null;

    try {
        
        fw = new FileWriter(f);

        String msg = "나는 fileWriter클래스의 예제에요";

        fw.write(msg);


    } catch (Exception e) {
        e.printStackTrace();

    } finally {

        try {
            
            if(fw != null){
                fw.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}//main
}