package ex5_buffer_input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Ex1_BufferInput {
    public static void main(String[] args) {

        // Buffered스트림
        // 파일을 읽거나 쓸 때 버퍼일 작업을 수행하여
        // 입출력 속도향상에 도움을 주는 스트림
        String path = "C:/myFile/work3.txt";
        File f = new File(path);
        byte[] result = new byte[(int) f.length()];

        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            bis.read(result);

            String res = new String(result);
            System.out.println(res);

        } catch (Exception e) {
            // TODO: handle exception
        } finally {

            try {
                //생성된 스트림은 반드시
                //만들어진(new) 연순으로 닫아준다.
                if (bis != null) {
                    bis.close();
                }

                if (fis != null) {
                    fis.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }// main
}
