package src.mod;

import src.db.User;
import src.db.UserWrite;

/**
 * Banking 추상 클래스
 * - 계좌 관련 작업(입금, 출금 등)의 기본 구조와 트랜잭션 처리를 담당하는 부모 클래스
 * - 구체적 입출금 작업은 상속받는 클래스에서 구현 (execute 추상 메소드)
 * - 트랜잭션 개념(롤백/커밋) 도입: 작업 중 예외 발생 시 원상복구 기능 제공
 */
public abstract class Banking {
    // 롤백을 위한 작업 전 복제본 User 객체(작업 이전 상태 저장)
    private User savePoint;   

    // 실제 작업 대상이 되는 User 객체(계좌주)
    protected User user;      

    /**
     * 생성자
     * - 계좌 작업을 시작할 때, 작업 대상 User 객체를 받아와 저장
     * - 동시에, 현재 User 상태를 savePoint로 별도 복제(깊은 복사)하여
     *   롤백 시 복구가 가능하도록 함.
     * @param user 계좌 작업의 대상이 되는 User(기존 정보)
     */
    public Banking(User user) {
        this.user = user; // 작업 대상 User 저장

        // 작업 직전 User의 모든 정보를 새로운 User 인스턴스로 깊은 복제(롤백 대비)
        savePoint = new User(
            user.getId(),            // 사용자 아이디 (고유값)
            user.getPassword(),      // 비밀번호 (평문 - 별도의 암호화 없음)
            user.getName(),          // 실명
            user.getAccountNumber(), // 계좌번호 (고유)
            user.getBalance()        // 현재 잔액
        );
    }

    /**
     * 계좌 작업(예금, 출금 등) 실행 메소드 (구현 강제: 자식 클래스에서 반드시 override)
     * @param money 거래금액(플러스: 입금, 마이너스: 출금 등)
     * @return 작업 성공(true), 실패(false)
     */
    public abstract boolean execute(int money);

    /**
     * 현재 작업 중인 User 객체 반환
     * - 작업 후 변경된 User 객체를 외부에서 읽거나 활용 가능
     * @return 작업 대상 User 객체
     */
    public User getUser() {
        return user;
    }

    /**
     * 롤백(rollback)
     * - 작업 중 문제가 생긴 경우, 작업 전 상태로 사용자 정보를 복원(취소)
     * - 저장된 savePoint 정보로 덮어씀(직렬화 파일에도 반영)
     * - 변경 전 원본 User 정보를 다시 사용자 파일에 저장
     */
    public void rollback() {
        // UserWrite 객체를 이용해 savePoint를 파일로 저장(작업 전 상태 복구)
        new UserWrite().writeInfo(savePoint);
    }

    /**
     * 커밋(commit)
     * - 작업이 정상적으로 끝난 경우, 변경된 User 객체를 영구 저장(파일 overwrite)
     * - user 객체의 변경 내용을 직렬화하여 반영
     */
    public void commit() {
        // UserWrite 객체로 변경된 user 정보를 파일에 저장(최신 상태 반영)
        new UserWrite().writeInfo(user);
    }
}
