package ex8_frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FrameMain {
    public static void main(String[] args) {
        
        Frame f = new Frame();
        f.setLayout(null);//자동배치 끄기
        f.setBounds(500, 200, 400, 400 );
        f.addWindowListener( new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            };
        } );

        Button btn1 = new Button("종료할까요?");
      
        btn1.setBounds(50, 100, 300, 250);
        
      

        


        // 프레임에 버튼 추가
        f.add(btn1);
       
        f.setVisible(true);



    }//main
}
