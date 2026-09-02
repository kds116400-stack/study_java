package ex1_socket;

import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        
        //window + r 키
        //ipconfig
        //192.168.0.38 //내 pc
        //192.168.0.46 //선생님  pc
        try {
            Socket s = new Socket("192.168.0.46", 3000); 
            
        } catch (Exception e) {
            // TODO: handle exception
        }


    }//main
}
