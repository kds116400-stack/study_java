package ex1_file;

import java.io.File;

public class Ex2_File {
    public static void main(String[] args) {

        String path = "c:/java";
        File f = new File(path);

        if (f.isDirectory()) { // !f.isFile()

            // patg경로의 하뤼 요소들의 이름을 가져온다
            String[] name = f.list();

            //하뤼목록들의 이름을 출력
            for(int i = 0; i < name.length; i++){
                System.out.println(name[i]);
            }

            

        }

    }// main
}
