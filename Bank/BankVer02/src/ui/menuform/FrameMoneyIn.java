package src.ui.menuform;

import javax.swing.*;
import java.awt.event.*;

import src.db.User;
import src.mod.Banking;
import src.mod.MoneyIn;
import src.ui.form.Form;
import src.ui.form.FormField;

/**
 * FrameMoneyIn 클래스
 * - 사용자가 입금 기능을 사용할 때 보여지는 입금 창 UI를 제공
 * - 금액 입력, 확인/뒤로가기 버튼, 입력값 검증, 입금 처리 등 담당
 */
public class FrameMoneyIn implements Form {

    /**
     * 입금 창을 띄우는 메서드
     * @param user      현재 로그인된 사용자(User 객체)
     * @param prevFrame 이전 메뉴 프레임(입금 완료/취소시 복귀용)
     */
    public void start(User user, JFrame prevFrame) {
        // 1. 입금용 프레임 생성 및 타이틀 지정
        JFrame f = Form.setFrame("입금");

        // 2. 입금 금액 입력 필드(FormField) 생성 및 프레임에 배치
        FormField ff = new FormField("입금할 금액");
        ff.setBounds(F, FF_H * 5, FF_W, FF_H);
        f.add(ff);

        // 3. "확인" 버튼(입금 실행) 생성 및 프레임에 배치
        JButton bt = new JButton("확인");
        bt.setBounds(BT_X, BT_Y * 6, BT_W, BT_H);
        f.add(bt);
        
        // 4. "뒤로가기" 버튼(이전 화면으로 복귀) 생성 및 프레임에 배치
        JButton back = Form.clearButton("뒤로가기 >", BACK);
        f.add(back);

        // 5. [입금액 입력: 키 입력 제한] - 숫자만 입력되도록 KeyListener 부착
        ff.getJTF().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // 만약 입력된 문자가 숫자가 아니면 해당 입력 무효화(입력창에 표시X)
                if (!Character.isDigit(c))
                    e.consume(); // 숫자가 아닐 때만 소비
            }
        });

        // 6. [확인(입금) 버튼 이벤트] - 입금 처리 로직
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 입력한 입금액 검증(정수 변환)
                    int money = Integer.parseInt(ff.getText());
                    // 입금 로직 담당 Banking 객체 생성
                    Banking bk = new MoneyIn(user);

                    // 입금 실행 성공하면 commit 및 안내 메시지, 프레임 전환
                    if (bk.execute(money)) {
                        bk.commit();
                        JOptionPane.showMessageDialog(f, "입금 완료!"); // 안내창
                        prevFrame.setVisible(true); // 이전 메뉴 창 다시 보이게
                        f.dispose(); // 입금 창 닫기
                    } else {
                        // 입금 실패시 롤백(실제 오류/예외 상황 대응)
                        bk.rollback();
                    }
                } catch (NumberFormatException ex) {
                    // 예외: 입력값이 비었거나 숫자가 아닐 때 경고
                    JOptionPane.showMessageDialog(f, "올바른 숫자를 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // 7. [뒤로가기 버튼 이벤트] - 이전 프레임 복귀 및 현재 창 닫기
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevFrame.setVisible(true);
                f.dispose();
            }
        });

        // 8. 모든 설정 완료 후 입금 프레임을 화면에 표시
        f.setVisible(true);
    }
}
