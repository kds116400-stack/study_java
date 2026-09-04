package src.ui.mainform;

import javax.swing.*;
import java.awt.event.*;

// import java.awt.Color;
// import java.awt.Font;

import src.mod.CheckUser;
import src.ui.form.Form;
import src.ui.form.FormField;
import src.ui.menuform.FrameMenu;

/**
 * FrameLogin 클래스
 * - 로그인 창 UI 및 관련 동작을 담당하는 클래스
 * - 아이디, 비밀번호 입력 필드와 로그인/뒤로가기 버튼, 각종 사용자 편의 기능 포함
 */
public class FrameLogin implements Form {

    /**
     * 로그인 창을 실행하는 메서드
     * @param cu      사용자 인증 및 정보 조회 담당 객체
     * @param prevFrame 이전 창(프레임), 뒤로가기 시 복귀용
     */
    public void start(CheckUser cu, JFrame prevFrame) {
        // 1. 로그인용 프레임 생성 및 타이틀 지정
        JFrame f = Form.setFrame("로그인");

        // 2. 입력항목(아이디, 비밀번호) 라벨 문자열 배열
        String[] str = { "아이디", "비밀번호" };
        // 입력 필드(FormField) 배열 (각 입력 항목별로 하나씩)
        FormField[] ff = new FormField[str.length];

        // 3. 입력 필드 생성 및 프레임 배치
        for (int i = 0; i < ff.length; i++) {
            // 비밀번호 항목은 ***** 처리해서 표시
            if (str[i].equals("비밀번호"))
                ff[i] = new FormField(str[i], true); // 두 번째 인자가 true면 JPasswordField
            else
                ff[i] = new FormField(str[i]);
            // 위치 및 크기 지정 (상수: F, FF_H, FF_W)
            ff[i].setBounds(F, FF_H * (i + 5), FF_W, FF_H);
            f.add(ff[i]);
        }

        // 4. "확인"(로그인) 버튼 생성 및 프레임 추가
        JButton bt = new JButton("확인");
        bt.setBounds(BT_X, BT_Y * 6, BT_W, BT_H);
        f.add(bt);

        // 5. "뒤로가기" 버튼(프리셋 스타일로) 생성 및 프레임 추가
        JButton back = Form.clearButton("뒤로가기 >", BACK);
        f.add(back);

        // 6. "확인" 버튼을 엔터(리턴키) 누르면 바로 동작하도록 설정
        f.getRootPane().setDefaultButton(bt);

        // ===================== [로그인 버튼 이벤트] =====================
        // "확인"(로그인) 버튼 클릭/엔터시 동작
        bt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // 입력 아이디/비밀번호 추출
                String inputId = ff[0].getText(); // 아이디
                String inputPw = new String(ff[1].getPassword()); // 비밀번호(패스워드필드는 char[] 반환)

                // 1. 로그인 인증(CheckUser로 확인)
                if (cu.checkLogin(inputId, inputPw)) {
                    // 로그인 성공: 안내 메시지 후 메뉴 창(사용자 정보 동반) 띄우고 로그인 창 닫기
                    JOptionPane.showMessageDialog(f, "로그인 성공");
                    f.dispose();
                    // 로그인 성공한 User 객체 전달하며 메뉴 프레임으로 이동
                    new FrameMenu().start(cu.getUser());

                } else {
                    // 로그인 실패: 경고 메시지, 입력창 비우고 아이디 입력창에 포커스 복원
                    JOptionPane.showMessageDialog(
                        f, 
                        "ID/PW 일치하지 않습니다.", 
                        "로그인 실패", 
                        JOptionPane.WARNING_MESSAGE
                    );
                    ff[0].getJTF().setText(""); // 아이디 필드 비우기
                    ff[1].getJTF().setText(""); // 비밀번호 필드 비우기
                    ff[0].requestFocus(); // 아이디 입력창에 포커스(자동 커서 이동)
                }

            }
        });

        // ===================== [뒤로가기 버튼 이벤트] =====================
        // "뒤로가기" 버튼 클릭시 동작
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 이전 프레임 다시 보이게 하고, 로그인 창 닫기
                prevFrame.setVisible(true);
                f.dispose();
            }
        });

        // 7. 모든 세팅 후 프레임 표시
        f.setVisible(true);
    }
}
