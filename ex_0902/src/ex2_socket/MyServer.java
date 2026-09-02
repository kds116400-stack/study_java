package ex2_socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer extends Thread {
    
    ServerSocket ss;

    public MyServer(){
        try {
            
            ss = new ServerSocket(3000);
            System.out.println("서버시작");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    @Override
    public void run() {

        InputStreamReader isr = null;
        BufferedReader br = null;

        while(true){

            try {
                
                Socket s = ss.accept();
                String ip = s.getInetAddress().getCanonicalHostName();

                //클라이언트가 보낸 문자열을 읽어온다
                isr = new InputStreamReader( s.getInputStream() );
                br = new BufferedReader(isr);

                br.readLine();

                String msg = br.readLine();

                System.out.println(ip + " : " + msg);

                

            } catch (Exception e) {
                // TODO: handle exception
            }finally {

                try {
                    
                    if(br != null) br.close();
                    if(isr != null) isr.close();

                } catch (Exception e) {
                    // TODO: handle exception
                }

            }

        }//while
        
    }

}
