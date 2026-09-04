package src.mod;

import src.db.User;
import src.db.UserRead;

/**
 * Send 클래스는 송금(transfer) 기능을 담당한다.
 * - 송금할 대상 계좌(수신자)를 검색
 * - 송신자에서 출금, 수신자에 입금(트랜잭션 처리)
 * - 수신자 정보 조회
 */
public class Send {

    // 송신자(User)와 수신자(User) 정보를 저장하는 필드
    private User sender, receiver;

    /**
     * 생성자
     * - 송신자 User 객체를 받아서 sender 필드에 저장.
     *   즉, 이 Send 인스턴스가 "누구로부터" 돈을 보낼지 고정하는 역할.
     * @param user 송신자 User 객체
     */
    public Send(User user){
        sender = user; // 송금 출발 계좌의 사용자 정보
    }

    /**
     * 계좌번호로 수신자(User)를 찾는다.
     * - UserRead 객체를 통해 시스템 내 모든 사용자 계좌목록에서 해당 계좌번호를 조회.
     * - 찾으면 receiver 필드에 저장(송금 대상 고정)
     * 
     * @param account 수신자 계좌번호 (int, 반드시 실제 존재하는 계좌번호여야 함)
     * @return true  : 계좌번호에 해당하는 사용자가 존재(송금 가능)
     *         false : 해당 계좌가 존재하지 않음(송금 불가)
     */
    public boolean findReceiver(int account){
        // UserRead().findByAccount로 계좌번호에 해당하는 User 객체 조회
        receiver = new UserRead().findByAccount(account);

        // 수신자 존재 여부 반환 (null이 아니면 존재)
        if(receiver != null)
            return true;
        return false;
    }

    /**
     * 실제 송금(transfer) 실행
     * - 송신자(sender) 계좌에서 돈을 출금(MoneyOut)
     * - 수신자(receiver) 계좌에 돈을 입금(MoneyIn)
     *   (둘 다 트랜잭션/롤백 구조)
     * - 어느 한 쪽이라도 실패하면 전체 작업을 롤백(원상복구)
     * 
     * [동작 순서]
     * 1. 출금(MoneyOut.execute)이 실패하면 롤백하고 false 반환
     * 2. 입금(MoneyIn.execute)이 실패하면 롤백하고 false 반환
     * 3. 둘 다 성공해야 커밋(commit)으로 반영 → true 반환
     * 
     * @param money 송금할 금액(양수)
     * @return true  : 정상적으로 송금(출금+입금) 모두 성공
     *         false : 출금/입금 둘 중 하나라도 실패
     */
    public boolean sendMoney(int money){
        // 송신자 출금 트랜잭션 객체(MoneyOut)
        Banking bOut = new MoneyOut(sender);
        // 수신자 입금 트랜잭션 객체(MoneyIn)
        Banking bIn = new MoneyIn(receiver);

        // 출금, 입금 각각 실행(실제 트랜잭션 발생)
        boolean s = bOut.execute(money); // 출금 처리 성공 여부
        boolean r = bIn.execute(money);  // 입금 처리 성공 여부

        // 출금 또는 입금 둘 중 하나라도 실패 시 전체 작업 원상복구(롤백)
        if(!s || !r){
            bOut.rollback(); // 출금 롤백(잔액 원복)
            bIn.rollback();  // 입금 롤백(잔액 원복)
            return false;    // 송금 실패 반환
        }

        // 출금&입금 모두 성공 → 영구 반영(커밋)
        bOut.commit(); // 출금 내용 저장
        bIn.commit();  // 입금 내용 저장
        return true;   // 송금 성공 반환
    }

    /**
     * 수신자(receiver) 아이디(주로 이름 또는 unique id, 계좌주 정보) 반환
     * - 반드시 findReceiver 성공 후 호출해야 정상 출력됨!!
     *
     * @return String : 수신자 id(계좌주 아이디/이름)
     */
    public String nameReceiver(){
        return receiver.getId();
    }
}
