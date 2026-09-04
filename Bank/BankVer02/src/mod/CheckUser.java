
package src.mod;

import java.util.Random;
import java.util.Set;

import src.db.*;

/**
 * CheckUser 클래스는 사용자와 관련된 각종 검사 및 저장 기능을 담당한다.
 *  - 아이디 중복 검사
 *  - 로그인 검증(아이디/비밀번호)
 *  - 신규 사용자 정보 저장
 *  - 랜덤 계좌번호 생성 및 중복 검사
 */
public class CheckUser {  // 사용자 관련 유효성 검증 클래스

    // 현재 로그인 중인 사용자 정보를 보관할 User 객체 변수
    private User user;

    // 현재 시스템에 등록된 모든 사용자(User) 정보 Set, 프로그램 초기화 시 UserRead에서 로딩
    private Set<User> set = new UserRead().findAll();

    /**
     * 현재 로그인된 사용자(User) 객체 반환
     * @return 로그인 중인 User 객체 (없으면 null)
     */
    public User getUser() {
        return user;
    }

    /**
     * 현재 메모리에 저장되어 있는 전체 User 집합 반환
     * @return Set<User> 모든 사용자 정보
     */
    public Set<User> getUserSet() {
        return set;
    }

    /**
     * 회원가입 시 아이디(ID)의 중복 여부를 검사
     * @param id 중복 체크할 아이디 (String)
     * @return true  : 이미 사용 중인 아이디 (중복)
     *         false : 사용 가능한 아이디 (미중복)
     */
    public boolean checkId(String id) {
        for (User u : set) {
            // User의 getId와 입력 id가 동일하면 중복이므로 true 반환
            if (u.getId().equals(id)) {
                return true; // 중복된 아이디 존재
            }
        }
        return false; // 중복 없음
    }

    /**
     * 로그인 시 아이디/비밀번호 일치 여부를 검사
     * @param id 입력받은 아이디(문자열)
     * @param pw 입력받은 비밀번호(문자열)
     * @return true  : 일치하는 계정 있음(로그인 성공)
     *         false : 일치하는 계정 없음(로그인 실패)
     */
    public boolean checkLogin(String id, String pw) {
        for (User u : set) {
            // 아이디와 비밀번호 모두 일치하는 User가 있는지 확인
            if (u.getId().equals(id) && u.getPassword().equals(pw)) {
                user = u; // 로그인 성공 시 해당 User 객체를 현재 user에 저장
                return true;
            }
        }
        // 일치하는 사용자 없음
        return false;
    }

    /**
     * 신규 회원(user) 정보를 생성하여 파일에 저장하고, 사용자 목록(Set)에도 추가
     * @param id      등록할 아이디(문자열)
     * @param pw      비밀번호(문자열)
     * @param name    사용자 이름(실명)
     * @param balance 초기 입금액(잔액)
     */
    public void writeUser(String id, String pw, String name, long balance) {
        // 1. 고유한 계좌번호 생성(중복 없도록)
        int accountNumber = createAccountNumber();

        // 2. User 객체 생성(입력 파라미터 및 계좌번호로)
        User u = new User(id, pw, name, accountNumber, balance);

        // 3. UserWrite 클래스를 이용하여 파일로 직렬화 저장
        UserWrite uw = new UserWrite();
        uw.writeInfo(u);

        // 4. 메모리 내 사용자 목록(Set)에 신규 User 추가
        set.add(u);

        // ※ 만약 외부에서 사용자 목록을 다시 읽어서 동기화하고 싶으면 아래 코드 사용
        // set = new UserRead().findAll();
    }
    
    /**
     * 8자리(100_000_000~999_999_999) 계좌번호를 랜덤으로 생성
     * 기존 계좌번호와의 중복이 없을 때까지 무한 반복 생성
     * @return int 생성된(중복 없는) 계좌번호
     */
    private int createAccountNumber() {
        Random rd = new Random();
        int accountNumber;
        // do-while로 중복 계좌번호가 아닐 때까지 반복 생성
        do {
            // 1억 ~ 9억9999만9999 사이 난수를 생성(계좌번호 형식)
            accountNumber = rd.nextInt(900_000_000) + 100_000_000;
        } while (checkAccountNumber(accountNumber)); // 중복이면 다시 랜덤 생성

        return accountNumber;
    }

    /**
     * 특정 계좌번호의 중복 여부 검사 (기존 Set 내 중복 발견 시 true 반환)
     * @param accountNumber 검사할 계좌번호(int)
     * @return true  : 중복 계좌번호 존재
     *         false : 중복 없음(사용 가능)
     */
    private boolean checkAccountNumber(int accountNumber) {
        // 모든 User 중 동일 계좌번호가 하나라도 있으면 true 반환
        for (User u : set) {
            if (u.getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false; // 중복 없음
    }
}
