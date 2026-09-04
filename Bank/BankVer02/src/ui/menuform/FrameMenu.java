package src.ui.menuform;

import javax.swing.*;
import java.awt.event.*;

import src.db.User;
import src.ui.form.Form;
import src.ui.mainform.FrameMain;

/**
 * FrameMenu 클래스
 * - 사용자(로그인 완료)가 거래 메뉴에 진입했을 때의 메뉴 화면을 담당
 * - 입금, 출금, 송금, 조회, 로그아웃 등 주요 거래 기능 버튼 제공
 */
public class FrameMenu implements Form {
    /**
     * 거래 메뉴 UI 프레임을 띄움
     * @param user 현재 로그인된 사용자 정보 (User 객체)
     */
    public void start(User user) {
        // 1. 거래 메뉴용 프레임 생성 및 타이틀 지정
        JFrame f = Form.setFrame("거래하기");

        // 2. 버튼명(라벨) 배열: 입금, 출금, 송금, 조회, 로그아웃
        String[] str = {"입금", "출금", "송금", "조회", "로그아웃"};
        // 버튼 객체들을 저장할 배열 생성
        JButton[] bt = new JButton[str.length];
        
        // 3. 각 버튼 생성 및 프레임에 배치
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new JButton(str[i]);
            // 버튼 위치 및 크기 설정 (BT_X, BT_Y, BT_W, BT_H는 UI 배치 상수)
            // i+2는 위쪽 여백을 위해 버튼을 아래부터 배치
            bt[i].setBounds(BT_X, BT_Y * (i + 2), BT_W, BT_H);
            f.add(bt[i]);
        }

        // 4. "입금" 버튼 액션 등록
        bt[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 입금 창(FrameMoneyIn) 오픈, 현재 사용자, 현재 프레임 전달
                new FrameMoneyIn().start(user, f);
                // 메뉴 창 숨기기 (입금 완료 후 다시 돌아올 수 있음)
                f.setVisible(false);
            }
        });

        // 5. "출금" 버튼 액션 등록
        bt[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 출금 창(FrameMoneyOut) 오픈
                new FrameMoneyOut().start(user, f);
                // 메뉴 창 숨기기
                f.setVisible(false);
            }
        });

        // 6. "송금" 버튼 액션 등록
        bt[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 송금 창(FrameSend) 오픈
                new FrameSend().start(user, f);
                // 메뉴 창 숨기기
                f.setVisible(false);
            }
        });

        // 7. "조회" 버튼 액션 등록
        bt[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 계좌조회 창(FrameView) 오픈
                new FrameView().start(user, f);
                // 메뉴 창 숨기기
                f.setVisible(false);
            }
        });

        // 8. "로그아웃" 버튼 액션 등록
        bt[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 메뉴 창 완전히 닫기
                f.dispose();
                // 메인 화면(FrameMain)으로 이동(로그아웃 처리)
                new FrameMain().start();
            }
        });

        // 9. 프레임 보이게 설정(화면에 표시)
        f.setVisible(true);
    }
}
