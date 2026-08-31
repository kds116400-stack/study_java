package ex5_listener;

import java.awt.*;
import java.awt.event.WindowAdapter;

public class FrameMain {
    public static void main(String[] args) {
        
        Frame f = new Frame();
        f.setBounds(500, 200, 400, 300);

        f.addWindowListener( new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            };
        } );

        f.setVisible(true);

    }//main
}
