package src.mod;

import src.db.User;

/**
 * MoneyOut 클래스
 * - Banking 추상 클래스를 상속받아, 계좌에 '출금' 처리를 담당하는 클래스이다.
 * - execute 메서드를 오버라이딩 하여 출금 로직을 구체적으로 구현한다.
 */
public class MoneyOut extends Banking {

    /**
     * 생성자
     * - 출금 작업을 수행할 User 객체를 받아 상위(Banking) 생성자에 전달한다.
     *   이 User 객체는 출금 대상 계좌를 의미한다.
     * @param user 계좌 출금 대상이 되는 사용자(실제 출금될 User 객체)
     */
    public MoneyOut(User user) {
        // 상위 Banking 클래스의 생성자를 호출하여 초기화 (user 저장 및 복제본 생성)
        super(user);
    }

    /**
     * execute 메서드 (출금 처리)
     * - 지정한 금액만큼 사용자의 계좌에서 출금(잔액 차감) 처리를 수행한다.
     * - 출금 금액이 1원 이상이어야 하며, 잔액보다 금액이 크면 출금이 불가하다.
     * - 출금 이후 실제로 user의 잔액(balance)이 감소된다.
     * 
     * [동작 상세]
     * 1. 출금 요청 금액이 0 이하(부정적 또는 0)이면 false 반환
     * 2. 출금 요청 금액이 현재 잔액보다 많을 경우(잔액 부족) false 반환
     * 3. 위 조건 통과 시, 잔액에서 금액을 차감한 뒤 true 반환(출금 성공)
     *
     * @param money 출금할 금액(정수, 1원 이상)
     * @return true  : 출금 처리 성공 (잔액 차감 완료)
     *         false : 금액 오류 또는 잔액 부족
     */
    @Override
    public boolean execute(int money) {
        // 1. 출금 금액이 0원 이하(음수 또는 0)라면 출금 불가
        if (money <= 0) {
            // 잘못된 금액 입력 - 실패 반환
            return false;
        }

        // 2. 현재 잔액보다 출금 요청 금액이 크면 출금 불가(잔액 부족)
        if (money > user.getBalance()) {
            // 출금 금액이 잔액보다 큼 - 실패 반환
            return false;
        }

        // 3. 정상적으로 출금 수행: 잔액 - 출금금액 연산
        long prevBalance = user.getBalance(); // 출금 전 잔액(디버깅 또는 기록용)
        long newBalance = prevBalance - money; // 출금 후 예상 잔액

        user.setBalance(newBalance); // User 객체의 잔액 필드 실제 업데이트

        // 4. 출금 처리 성공 반환
        return true;
    }
}
