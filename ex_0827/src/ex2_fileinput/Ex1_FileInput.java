package ex2_fileinput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex1_FileInput {
    public static void main(String[] args) {
        
        String path = "C:/myFile/test.txt";
        File f = new File(path);
        FileInputStream fis = null;

        if(f.exists()){

            try {
                //파일과 연결된 입력스트림
                fis = new FileInputStream( f );
                
                int code = 0;

                //스트림은 더이상 읽을것이 없다면 파일의 끝(EOF)인
                //-1을 변환하게 되어있다.
                //한글은 2byte문자이기 떄문에 한글을 읽는데 문제가 발생ㄹ
                while ( (code = fis.read() ) != -1 ){
                    System.out.print((char)code);
                    
                }//while

                //사용을 마친 스트림은 반드시 닫아줘야 한다
                //fis.close();

            } catch (Exception e) {
                // TODO: handle exception
            }finally {

                try {
                    fis.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }


            }

        }

    }//main
}
