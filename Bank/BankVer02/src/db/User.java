package src.db;

import java.io.Serializable;

/**
 * User 클래스
 * - 한 명의 사용자의 정보를 저장하는 데이터 클래스(VO, DTO역할)
 * - 계좌 관리 등에서 사용자 정보 및 계좌 관련 필드를 제공
 * - Serializable 인터페이스 구현: 파일로 객체를 저장/불러오기에 필수
 */
public class User implements Serializable {
    // 필드 선언부(멤버 변수)

    /**
     * 사용자 계정의 아이디
     */
    private String id;              

    /**
     * 사용자 계정의 비밀번호(평문 저장, 보안 주의)
     */
    private String password;        

    /**
     * 실제 사용자 이름(실명)
     */
    private String name;            

    /**
     * 계좌번호 (고유 값)
     */
    private int accountNumber;      

    /**
     * 계좌 잔액(원 단위, 음수 불가)
     */
    private long balance;           

    /**
     * User 생성자
     * @param id 사용자가 로그인을 위해 입력하는 아이디(고유)
     * @param password 사용자가 로그인을 위해 입력하는 비밀번호
     * @param name 사용자의 실명(이름)
     * @param accountNumber 해당 사용자의 계좌번호(숫자형, 고유)
     * @param balance 해당 계좌의 현재 잔액(금액)
     */
    public User(String id, String password, String name, int accountNumber, long balance) {
        this.id = id;                         // 아이디 초기화
        this.password = password;             // 비밀번호 초기화
        this.name = name;                     // 이름 초기화
        this.accountNumber = accountNumber;   // 계좌번호 초기화
        this.balance = balance;               // 잔액 초기화
    }

    /**
     * 아이디 반환
     * @return 사용자 아이디
     */
    public String getId() {
        return id;
    }

    /**
     * 비밀번호 반환
     * @return 사용자 비밀번호(평문 반환)
     */
    public String getPassword() {
        return password;
    }

    /**
     * 이름 반환
     * @return 사용자 실명
     */
    public String getName() {
        return name;
    }

    /**
     * 계좌번호 반환
     * @return int형 계좌번호
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * 잔액 반환
     * @return long형 계좌 잔액
     */
    public long getBalance() {
        return balance;
    }

    /**
     * 잔액 설정(갱신)
     * @param balance 새롭게 저장할 잔액(음수도 technically 가능하니 주의!)
     */
    public void setBalance(long balance) {
        this.balance = balance;
    }
}
