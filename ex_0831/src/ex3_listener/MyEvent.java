package ex3_listener;

import java.awt.event.WindowListener;

public class MyEvent implements WindowListener {
    @Override
    public void windowOpened(java.awt.event.WindowEvent e) {
        // 창이 열릴 때 호출됩니다.
    }

    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        // 창이 닫힌 후에 호출됩니다.
    }

    @Override
    public void windowIconified(java.awt.event.WindowEvent e) {
        // 창이 아이콘화(최소화)될 때 호출됩니다.
    }

    @Override
    public void windowDeiconified(java.awt.event.WindowEvent e) {
        // 아이콘화된 창이 다시 원래대로 돌아올 때 호출됩니다.
    }

    @Override
    public void windowActivated(java.awt.event.WindowEvent e) {
        // 창이 활성화될 때 호출됩니다.
    }

    @Override
    public void windowDeactivated(java.awt.event.WindowEvent e) {
        // 창이 비활성화될 때 호출됩니다.
    }
}
