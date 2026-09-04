package src.ui.menuform;

import javax.swing.*;
import java.awt.event.*;

import src.mod.Send;
import src.ui.form.Form;
import src.ui.form.FormField;
import src.db.User;

/**
 * FrameSending 클래스
 * - 송금 금액 입력 및 실제 송금 처리 UI/로직을 담당하는 클래스
 * - 수취인 이름 안내, 금액 입력란, 확인/뒤로가기 버튼, 숫자 입력 제한, 송금 실행 등 포함
 */
public class FrameSending implements Form{
    /**
     * 송금(금액 입력 및 실행) 프레임을 시작하는 메서드
     * 
     * @param user      현재 로그인된 사용자(User 객체)
     * @param prevFrame 이전 프레임(메뉴 창 등), 뒤로가기 복귀용
     * @param send      수취인 정보 및 송금 컨트롤러 역할을 하는 Send 객체
     */
    public void start(User user, JFrame prevFrame, Send send) {
        // 1. 송금용 프레임 생성 및 타이틀 지정("송금")
        JFrame f = Form.setFrame("송금");

        // 2. 송금 수취인 이름 안내 라벨 생성 및 배치
        // ex) "홍길동님에게 얼마를 보내시겠습니까?"
        JLabel lb = new JLabel(send.nameReceiver() + "님에게 얼마를 보내시겠습니까?");
        lb.setBounds(F, FF_H * 5, FF_W, FF_H);
        f.add(lb);
        
        // 3. 송금 금액 입력 필드(FormField) 생성 및 프레임에 추가
        FormField ff = new FormField("송금할 금액");
        ff.setBounds(F, FF_H * 6, FF_W, FF_H);
        f.add(ff);

        // 4. "확인" 버튼 생성 및 프레임에 추가 (송금 실행 버튼)
        JButton bt = new JButton("확인");
        bt.setBounds(BT_X, BT_Y * 6, BT_W, BT_H);
        f.add(bt);
        
        // 5. "뒤로가기" 버튼(클리어 스타일) 생성 및 프레임에 추가
        JButton back = Form.clearButton("뒤로가기 >", BACK);
        f.add(back);

        // 6. [송금 금액 입력란: 숫자만 입력되게 KeyListener 추가]
        ff.getJTF().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // 만약 입력 문자가 숫자가 아니면 입력 무효화(입력란에 입력X)
                if(!Character.isDigit(c))
                    e.consume(); // 숫자가 아니면 소비하여 입력 차단
            }
        });

        // 7. [확인(송금) 버튼 클릭 이벤트] - 실제 송금 실행 로직
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 입력 필드로부터 송금 금액을 정수로 변환 (예외 가능성 있으니 try-catch)
                    int money = Integer.parseInt(ff.getText());
                    
                    // send 객체를 통해 실제 송금 시도(잔액 및 계좌 검사 등 내부에서 수행됨)
                    if(send.sendMoney(money)){
                        // 송금 성공!
                        JOptionPane.showMessageDialog(f, "송금 완료!"); // 성공 안내
                        prevFrame.setVisible(true); // 이전 메뉴 프레임 다시 표시
                        f.dispose(); // 현재(송금) 프레임 닫기
                    }
                    else {
                        // 송금 실패(잔액 부족, 기술적 오류 등 케이스)
                        JOptionPane.showMessageDialog(f, "송금 실패!"); // 실패 안내
                    }
                } catch(NumberFormatException ex){
                    // 금액 입력이 비었거나 숫자가 아닐 때 예외 처리
                    JOptionPane.showMessageDialog(f, "금액을 올바른 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                    ff.getJTF().setText("");  // 입력란 초기화
                    ff.requestFocus();        // 입력란에 커서 복귀
                }
            }
        });

        // 8. [뒤로가기 버튼 클릭 이벤트] - 이전 프레임 복귀 및 현재 창 닫기
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevFrame.setVisible(true); // 이전 프레임 다시 보이기
                f.dispose(); // 현재(송금) 프레임 닫기
            }
        });

        // 9. 모든 세팅 완료 후 프레임 표시
        f.setVisible(true);
    }
}
