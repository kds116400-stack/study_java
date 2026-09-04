package src.ui.form;

import javax.swing.*;

/**
 * FormField 클래스
 * - 라벨(JLabel)과 텍스트 입력창(JTextField 또는 JPasswordField)을 한 번에 제공하는 JPanel 확장 클래스입니다.
 * - 회원가입, 로그인 등에서 (이름)/(아이디)/(암호) 필드를 빠르게 만들기 위해 사용합니다.
 */
public class FormField extends JPanel {
    // -------------------------------------------------------------------
    // [필드]
    // -------------------------------------------------------------------
    private int l = 120;  // 라벨(Label)의 너비(px), 왼쪽에 위치 (변수명: l = label)
    private int f = 210;  // 입력 필드(Field)의 너비(px), 오른쪽에 위치
    private int h = 40;   // 필드 전체 높이(px)

    private JTextField tf;   // 입력 필드(텍스트박스 or 패스워드박스 역할, 실제 입력 컴포넌트)
    private JLabel lb;       // 필드 왼쪽에 고정된 라벨(JLabel)

    // -------------------------------------------------------------------
    // [생성자] : 일반 텍스트 입력 필드용
    // -------------------------------------------------------------------
    /**
     * 일반 텍스트 입력 필드 생성자
     * @param text 필드 왼쪽 라벨에 표시할 문자열 (예: "이름", "아이디" 등)
     */
    public FormField(String text) {
        // 레이아웃 매니저 비활성화 (절대 위치 직접 지정)
        setLayout(null);

        // 라벨 생성: 중앙 정렬, 위치(0,0), 크기(l,h)
        lb = new JLabel(text, SwingConstants.CENTER);
        lb.setBounds(0, 0, l, h);

        // 텍스트 입력 필드 생성: 위치(l,0), 크기(f,h) - 라벨 오른쪽에 붙음
        tf = new JTextField();
        tf.setBounds(l, 0, f, h);

        // 컴포넌트를 패널에 추가 (왼쪽:라벨, 오른쪽:텍스트박스)
        add(lb);
        add(tf);
    }

    // -------------------------------------------------------------------
    // [생성자] : 패스워드 입력 필드 지원 (오버로드)
    // -------------------------------------------------------------------
    /**
     * 패스워드 입력 필드 생성자
     * @param text 필드 라벨에 표시할 문자열
     * @param pw   true: 패스워드필드(JPasswordField) / false: 일반 텍스트필드
     */
    public FormField(String text, boolean pw) {
        // 레이아웃 매니저 비활성화 (절대 위치 직접 지정)
        setLayout(null);

        // 라벨 생성 : 중앙 정렬, 위치/크기 동일
        lb = new JLabel(text, SwingConstants.CENTER);
        lb.setBounds(0, 0, l, h);

        // 입력필드 생성: pw가 true이면 JPasswordField, 아니면 JTextField
        tf = new JPasswordField();
        tf.setBounds(l, 0, f, h);

        // 컴포넌트를 패널에 추가
        add(lb);
        add(tf);
    }

    // -------------------------------------------------------------------
    // [메서드] 입력 문자열 반환 (일반 텍스트 필드용)
    // -------------------------------------------------------------------
    /**
     * 입력 필드의 문자열 반환 (JTextField용)
     * @return 입력한 문자열(일반 문자열)
     */
    public String getText() {
        return tf.getText();
    }
    
    // -------------------------------------------------------------------
    // [메서드] 패스워드 문자열 반환 (JPasswordField용)
    // -------------------------------------------------------------------
    /**
     * 패스워드 필드일 경우, 입력한 비밀번호 문자열 반환
     * - 내부 tf 객체를 JPasswordField로 형변환, getPassword()로 문자 배열 추출
     * - 문자 배열을 문자열로 변환해서 반환
     * @return 입력한 패스워드(문자열)
     */
    public String getPassword() {
        // 입력 필드가 JPasswordField일 경우, getPassword() 사용
        char[] c = ((JPasswordField) tf).getPassword(); // 암호 입력 문자 배열
        String password = String.valueOf(c);            // 배열 → 문자열 변환
        return password;
    }

    // -------------------------------------------------------------------
    // [메서드] 내부 입력 컴포넌트 반환 (직접 참조 필요시)
    // -------------------------------------------------------------------
    /**
     * 현재 내부에서 사용 중인 JTextField(JPasswordField 포함) 객체 반환
     * - 외부에서 입력 필드에 직접 접근하고자 할 때 사용
     * @return JTextField 내부 입력필드 객체
     */
    public JTextField getJTF() {
        return tf;
    }

}