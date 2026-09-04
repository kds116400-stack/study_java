package src.ui.menuform;

import javax.swing.*;
import java.awt.event.*;

import src.db.User;
import src.ui.form.Form;
import src.ui.form.FormLabel;

/**
 * FrameView 클래스
 * - 사용자의 기본 정보(이름, 계좌번호, 잔액)를 조회/표시하는 UI 프레임을 구현
 * - 뒤로가기 버튼을 통해 이전 메뉴로 돌아갈 수 있음
 */
public class FrameView implements Form {
    /**
     * 조회 프레임을 생성하여 사용자 정보를 표시하는 메서드
     * 
     * @param user      현재 로그인된 사용자(User 객체)
     * @param prevFrame 이전 메뉴 프레임(뒤로가기 시 복귀용)
     */
    public void start(User user, JFrame prevFrame) {
        // 1. "조회"라는 타이틀을 가진 프레임을 생성
        JFrame f = Form.setFrame("조회");

        // 2. 사용자 정보(이름, 계좌번호, 잔액)를 표시할 FormLabel 배열 생성
        FormLabel[] lb = new FormLabel[3];
        // lb[0] : 이름 라벨
        lb[0] = new FormLabel("이름", user.getName());
        // lb[1] : 계좌번호 라벨 (정수 -> 문자열 변환)
        lb[1] = new FormLabel("계좌번호", String.valueOf(user.getAccountNumber()));
        // lb[2] : 잔액 라벨 (정수 -> 문자열 변환)
        lb[2] = new FormLabel("잔액", String.valueOf(user.getBalance()));

        // 3. 라벨들을 프레임에 순서대로 배치
        for (int i = 0; i < lb.length; i++) {
            // setBounds(x좌표, y좌표, 너비, 높이)
            // 20픽셀 x, 60*(i+2) 픽셀 y, 너비 300, 높이 50로 각 라벨 배치
            lb[i].setBounds(20, 60 * (i + 2), 300, 50);
            f.add(lb[i]);
        }

        // 4. "뒤로가기" 버튼 생성 및 프레임에 추가
        // BACK 상수(좌표 등)는 Form 인터페이스/부모에서 제공
        JButton back = Form.clearButton("뒤로가기 >", BACK);
        f.add(back);

        // 5. 뒤로가기 버튼 이벤트 등록
        // 클릭 시 이전 프레임을 다시 보이게 하고, 현재(조회) 창을 닫음
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevFrame.setVisible(true); // 이전 메뉴 프레임 다시 보이기
                f.dispose();                // 현재(조회) 프레임 닫기
            }
        });

        // 6. 모든 UI 세팅 완료 후 조회 프레임을 화면에 표시
        f.setVisible(true);
    }
}
