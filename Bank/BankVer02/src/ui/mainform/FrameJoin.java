package src.ui.mainform;

import javax.swing.*;
import java.awt.event.*;

import src.mod.CheckUser;
import src.ui.form.Form;
import src.ui.form.FormField;

/**
 * FrameJoin 클래스
 * - 사용자 회원가입 폼 UI 및 관련 이벤트를 담당
 * - 아이디, 비밀번호, 이름, 예치금 입력 필드와 중복 검사, 완료, 뒤로가기 버튼 제공
 */
public class FrameJoin implements Form {
    /**
     * 회원가입 프로세스를 시작하는 메서드
     * @param cu 사용자 검증 및 생성용 CheckUser 객체
     * @param prevFrame 이전 프레임(뒤로가기용)
     */
    public void start(CheckUser cu, JFrame prevFrame) {
        // 메인 회원가입 Frame 생성 및 설정
        JFrame f = Form.setFrame("회원가입");

        // 회원가입 입력 항목(라벨)들 정의
        String[] str = {"아이디", "비밀번호", "이름", "예치금"};
        // 각 입력필드를 저장할 배열
        FormField[] ff = new FormField[str.length];

        // 모든 입력필드(아이디, 비밀번호, 이름, 예치금) 생성 및 프레임에 추가
        for (int i = 0; i < ff.length; i++) {
            // 비밀번호일 경우 패스워드 필드 생성
            if (str[i].equals("비밀번호"))
                ff[i] = new FormField(str[i], true);
            else
                ff[i] = new FormField(str[i]);

            // 아이디 위치만 따로 조정, 나머지는 아래쪽에 배치
            if (str[i].equals("아이디"))
                ff[i].setBounds(F, FF_H * (i + 3), FF_W, FF_H); // y = 150
            else
                ff[i].setBounds(F, FF_H * (i + 4), FF_W, FF_H); // y = 250 등
            // 입력 필드를 프레임에 추가
            f.add(ff[i]);
        }

        // "중복 검사" 버튼 생성 및 배치 (아이디 입력 우측)
        JButton check = Form.clearButton("중복 검사 >", 190);
        f.add(check);

        // 중복 검사 결과를 표시할 라벨 - 기본 "사용 불가" (초기값)
        JLabel lb = new JLabel("사용 불가");
        lb.setBounds(220, 190, BT_W, FF_H);
        f.add(lb);

        // "확인" 버튼(회원가입 완료 버튼) 생성 및 배치
        JButton bt = new JButton("확인");
        bt.setBounds(BT_X, BT_Y * 6, BT_W, BT_H);
        f.add(bt);

        // "뒤로가기" 버튼(이전 화면 복귀용) 생성 및 배치
        JButton back = Form.clearButton("뒤로가기 >", BACK);
        f.add(back);

        // ========== [이벤트: 아이디 중복 검사 버튼] ==========
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 아이디 입력값 읽기
                String id = ff[0].getText();
                // 아이디가 비어있지 않고, 아이디가 DB에 이미 존재하지 않으면 "사용 가능"
                if (!id.isEmpty() && !cu.checkId(id))
                    lb.setText("사용 가능");
                else
                    lb.setText("사용 불가");
            }
        });

        // ========== [이벤트: 예치금 입력 - 숫자만 입력 가능 제한] ==========
        // 예치금(JTextField)에 키 리스너 추가: 숫자 문자만 입력 허용
        ff[3].getJTF().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // 만약 키가 숫자가 아니면, 입력 이벤트를 소비하여 입력 무효화
                if (!Character.isDigit(c))
                    e.consume();
            }
        });

        // ========== [이벤트: "확인" 버튼] ==========
        // 회원 정보 최종 기입 및 유효성 검증, 가입 처리
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // 아이디가 "사용 가능" 상태가 아니면 경고 메시지
                if (!lb.getText().equals("사용 가능")) {
                    JOptionPane.showMessageDialog(f, "아이디 중복 검사를 해주세요.");
                    return;
                }
                // 각 입력값 추출
                String id = ff[0].getText();
                String pw = new String(ff[1].getPassword()); // 비밀번호는 char[] → String
                String name = ff[2].getText();
                long bal;

                // 예치금(숫자) 파싱, 숫자가 아니면 오류 및 재입력 유도
                try {
                    bal = Long.parseLong(ff[3].getText());
                } catch (NumberFormatException exc) { // 숫자 변환 실패
                    JOptionPane.showMessageDialog(f, "숫자로 입력해주세요.");
                    return;
                }

                // 모든 필수항목 입력 확인
                if (id.isEmpty() || pw.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "모든 항목을 입력해주세요.");
                    return;
                }

                // 모두 유효하면 회원 등록(저장) 처리
                cu.writeUser(id, pw, name, bal);

                // 가입 완료 메시지 및 메인 창으로 이동
                JOptionPane.showMessageDialog(f, "회원가입 완료!");
                f.dispose();
                new FrameMain().start();
            }
        });

        // ========== [이벤트: "뒤로가기" 버튼] ==========
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevFrame.setVisible(true); // 이전 프레임 다시 보이게
                f.dispose(); // 현재 창 닫기
            }
        });

        // 모든 설정 완료 후 Frame 표시
        f.setVisible(true);
    }
}
