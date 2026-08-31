package ex6_button;

import java.awt.Color;

import java.awt.Frame;
import java.awt.event.WindowAdapter;

public class NewFrame extends Frame{
    
    public NewFrame( Frame f ){

        setBounds(f.getX() + 100, f.getY() + 100, 200, 100);
        setBackground(Color.YELLOW);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                //열려있는 모든 프레임을 종료
                // System.exit(0);

                //현재 프레임만 단독으로 종료
                dispose();
            };
        });
        //새로 생성되는 현재 프레임의 크기를 고정
        setResizable(false);
        
        setVisible(true);


    }//생성자

}
