package ex1_file;

import java.io.File;

public class Ex4_File {
    public static void main(String[] args) {
        
        String path = "c:/myFile/abc";
        File f = new File(path);

        //f가 참조가하고 있는 경로가 물리적으로 존재하지 않을 때
        if(!f.exists()){
            System.out.println("폴더를 생성합니다");
            f.mkdirs();
        }

    }//main
}
