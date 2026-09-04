package src.ui.mainform;

import javax.swing.*;
import java.awt.event.*;

import src.mod.CheckUser;
import src.ui.form.Form;

/**
 * FrameMain 클래스
 * - 은행 프로그램의 메인 화면(첫 진입 UI) 역할을 담당
 * - 로그인, 회원가입, 종료 버튼 제공
 */
public class FrameMain implements Form {

    // 사용자 인증 및 정보 관리를 담당하는 CheckUser 객체(로그인/회원가입 공통 사용)
    CheckUser cu;

    /**
     * 생성자
     * - CheckUser 객체를 생성하여 초기화
     */
    public FrameMain() {
        cu = new CheckUser();
    }
    
    /**
     * 메인 화면(프레임)을 띄우는 메서드
     * - 버튼 레이아웃, 이벤트 리스너 등을 설정
     */
    public void start() {
        // 1. 메인 프레임 생성 및 타이틀 지정("4조 은행" 표기)
        JFrame f = Form.setFrame("4조 은행");

        // 2. 버튼명(라벨) 배열: 로그인, 회원가입, 종료
        String[] str = {"로그인", "회원가입", "종료"};
        
        // 3. 버튼 배열 생성 및 각 버튼 생성
        JButton[] bt = new JButton[str.length];
        for (int i = 0; i < bt.length; i++) {
            // i번째 버튼 생성 및 라벨 지정
            bt[i] = new JButton(str[i]);
            // 화면 내에서의 위치 및 크기 지정 (상수 활용)
            bt[i].setBounds(BT_X, BT_Y * (i + 4), BT_W, BT_H);
            // 버튼을 메인 프레임에 추가
            f.add(bt[i]);
        }

        // 4. "로그인" 버튼 클릭 시 동작 정의
        bt[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인 창으로 이동(현재 메인 창의 CheckUser 객체, 프레임 전달)
                new FrameLogin().start(cu, f);

                // 메인 창은 닫기(리소스 해제)
                f.dispose();
            }
        });

        // 5. "회원가입" 버튼 클릭 시 동작 정의
        bt[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 회원가입 창으로 이동(현재 메인 창의 CheckUser 객체, 프레임 전달)
                new FrameJoin().start(cu, f);

                // 메인 창은 닫기(리소스 해제)
                f.dispose();
            }
        });

        // 6. "종료" 버튼 클릭 시 동작 정의
        bt[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 프로그램 종료를 위해 메인 프레임 닫기(종료)
                f.dispose();
            }
        });

        // 7. 버튼 및 UI 세팅 완료 후, 메인 창을 화면에 표시
        f.setVisible(true);
    }
}
