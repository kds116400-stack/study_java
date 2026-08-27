package ex2_fileinput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex5_work {
    public static void main(String[] args) throws IOException {
        
        //C:/myFile/work2.txt의 내용을 읽어서
        //회문인지 판단하시오
        //-------------------
        //토마토은(는) 회문입니다

        String path = "C:/myFile/work2.txt";
        File f = new File(path);
        byte[] console = new byte[ (int)f.length() ];
        FileInputStream fis = null;

        String ori = "";
        String rev = "";

        try {

            fis = new FileInputStream(f);

            fis.read(console);
            ori = new String(console).trim();

            StringBuffer sb = new StringBuffer(ori);
            rev = sb.reverse().toString();

            //원본문자열(ori)을 뒤집어서 reb에 저장
            // for(int i = ori.length()-1; i >= 0; i--){

            //     rev += ori.charAt(i);

            // }//for

            if(ori.equals(rev)){
                System.out.println(ori + "은(는) 회문");
            }else{
                System.out.println(ori + "은(는) 안회문");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally{
            if(fis != null){
                fis.close();
            }
        }


    }//main
}
