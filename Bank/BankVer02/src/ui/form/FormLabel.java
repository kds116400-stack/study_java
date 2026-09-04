package src.ui.form;

import javax.swing.*;

/**
 * FormLabel 클래스
 * - 두 개의 라벨(JLabel)을 수직으로 배치하는 역할을 하는 JPanel 확장 클래스입니다.
 * - 각 라벨은 지정한 텍스트를 중앙 정렬하여 보여줍니다.
 */
public class FormLabel extends JPanel{

    // 라벨 두 개를 저장할 배열
    JLabel[] lb;
    
    /**
     * FormLabel 생성자
     * - 두 개의 문자열을 받아 각각 라벨로 만들어 수직(위/아래) 배치합니다.
     * @param str  첫 번째(윗줄) 라벨에 표시할 텍스트
     * @param text 두 번째(아랫줄) 라벨에 표시할 텍스트
     */
    public FormLabel(String str, String text){
        // 레이아웃 매니저 비활성화(절대 위치 지정)
        setLayout(null);

        // 라벨 배열(2칸짜리) 생성
        lb = new JLabel[2];

        // 첫 번째 라벨 객체 생성 및 가운데 정렬, 텍스트 지정
        lb[0] = new JLabel(str, SwingConstants.CENTER);
        // 두 번째 라벨 객체 생성 및 가운데 정렬, 텍스트 지정
        lb[1] = new JLabel(text, SwingConstants.CENTER);

        // 첫 번째 라벨 위치/크기 지정: (x=0, y=0)에서 시작, 폭 300px, 높이 20px
        lb[0].setBounds(0, 0, 300, 20);
        // 두 번째 라벨은 첫 번째 라벨 아래(20px 아래) 배치, 동일 폭/높이
        lb[1].setBounds(0, 20, 300, 20);

        // 두 라벨을 패널에 추가(좌→우 순환문 사용)
        for (JLabel l : lb) {
            add(l);
        }
    }
}
