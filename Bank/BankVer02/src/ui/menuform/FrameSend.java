package src.ui.menuform;

import javax.swing.*;
import java.awt.event.*;

import src.mod.Send;
import src.ui.form.Form;
import src.ui.form.FormField;
import src.db.User;

/**
 * FrameSend 클래스
 * - 송금 기능에서 계좌번호 입력 및 수취인 확인(송금 진행 단계 진입) UI를 담당
 * - 계좌 입력 필드, 확인/뒤로가기 버튼, 입력 숫자 제한, 수취인 체크 등 상세 주석 포함
 */
public class FrameSend implements Form {
    /**
     * 송금(계좌번호 입력) 프레임 실행 메서드
     * @param user      현재 로그인된 사용자(User 객체)
     * @param prevFrame 이전(메뉴) 프레임, 뒤로가기 시 복귀용
     */
    public void start(User user, JFrame prevFrame) {
        // 1. 송금용 프레임 생성 및 타이틀 지정("송금")
        JFrame f = Form.setFrame("송금");

        // 2. 계좌번호 입력을 위한 FormField 객체 생성 및 배치
        FormField ff = new FormField("계좌 입력");
        ff.setBounds(F, FF_H * 5, FF_W, FF_H); // 정해진 위치/크기
        f.add(ff);

        // 3. 안내(또는 오류 등 메시지)용 라벨 생성 및 배치 (현재 빈 문자열)
        JLabel lb = new JLabel("");
        lb.setBounds(F, FF_H * 6, FF_W, FF_H);
        f.add(lb);

        // 4. "확인" 버튼 생성 및 프레임에 추가 (송금 진행용)
        JButton bt = new JButton("확인");
        bt.setBounds(BT_X, BT_Y * 6, BT_W, BT_H);
        f.add(bt);

        // 5. "뒤로가기" 버튼(클리어 스타일) 생성 및 프레임에 추가
        JButton back = Form.clearButton("뒤로가기 >", BACK);
        f.add(back);

        // 6. 계좌번호 입력 필드에 KeyListener 부착: 숫자만 입력 허용
        ff.getJTF().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // 입력값이 숫자가 아니면 입력 무효화 (입력란에 나타나지 않음)
                if (!Character.isDigit(c))
                    e.consume(); // 숫자가 아닐 때 소비하여 차단
            }
        });

        // 7. "확인" 버튼 클릭 이벤트 등록: 계좌 확인 및 송금 진행 창으로 이동
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 사용자 입력값(계좌번호) 정수로 변환
                    int account = Integer.parseInt(ff.getText());

                    // Send 객체(송금 컨트롤러) 생성, 해당 계좌 존재/유효성 체크
                    Send send = new Send(user);
                    if (send.findReceiver(account)) {
                        // 찾은 경우: 수취인 이름 안내 및 송금 진행 단계로 이동
                        JOptionPane.showMessageDialog(f, send.nameReceiver() + "님에게 송금을 진행합니다");
                        new FrameSending().start(user, prevFrame, send);
                        f.dispose(); // 현재 계좌 입력 창 닫기
                    } else {
                        // 수취인 찾기 실패시(없는 계좌 등) 안내 메시지 표시
                        JOptionPane.showMessageDialog(f, "해당 계좌를 찾을 수 없습니다.", "오류", JOptionPane.WARNING_MESSAGE);
                        ff.getJTF().setText(""); // 계좌 입력 창 초기화
                        ff.requestFocus(); // 입력 창에 커서 복귀
                    }
                } catch (NumberFormatException ex) {
                    // 예외: 입력값이 비었거나 숫자가 아닐 때 경고 (중복방지용)
                    JOptionPane.showMessageDialog(f, "올바른 계좌번호(숫자)를 입력하세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                    ff.getJTF().setText(""); // 계좌 입력 창 초기화
                    ff.requestFocus(); // 입력 창에 커서 복귀
                }
            }
        });

        // 8. "뒤로가기" 버튼 이벤트 등록: 이전 메뉴로 복귀
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevFrame.setVisible(true); // 이전 메뉴 창 다시 표시
                f.dispose();                // 현재(송금 입력) 창 닫기
            }
        });

        // 9. 모든 설정 완료 후 프레임 보이게
        f.setVisible(true);
    }
}
