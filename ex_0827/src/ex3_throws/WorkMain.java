package ex3_throws;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WorkMain {
    public static void main(String[] args) {
        
        WorkSub1 w1 = new WorkSub1();
        WorkSub2 w2 = new WorkSub2();

        //Sub1과 Sub2에서 던져준(throws) 예외에 대한 처리를
        //현재 클래스에서 묶어서 해결한다
        try {
            w1.result();
            w2.result();
            
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } catch (IOException e){

        }

    }//main
}
