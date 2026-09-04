package src.mod;

import src.db.User;

/**
 * MoneyIn 클래스
 * - Banking 추상 클래스를 상속받아, 계좌에 '입금' 처리를 담당하는 클래스이다.
 * - execute 메서드를 오버라이딩 하여 입금 로직을 구체적으로 구현한다.
 */
public class MoneyIn extends Banking {

    /**
     * 생성자
     * - 입금 작업을 수행할 User 객체를 받아 상위(Banking) 생성자에 전달한다.
     *   이 User 객체는 입금 대상 계좌를 의미한다.
     * @param user 계좌 입금 대상이 되는 사용자(실제 입금될 User 객체)
     */
    public MoneyIn(User user) {
        // 상위 Banking 클래스의 생성자를 호출하여 초기화 (user 저장 및 복제본 생성)
        super(user);
    }

    /**
     * execute 메서드 (입금 처리)
     * - 지정한 금액만큼 사용자의 계좌에 입금(잔액 증가) 처리를 수행한다.
     * - 입금 금액이 1원 이상이어야만 정상적으로 입금이 된다.
     * - 입금 이후 실제로 user의 잔액(balance)이 증가된다.
     * @param money 입금할 금액(양수)
     * @return true  : 입금 처리 성공 (잔액 증가)
     *         false : 0원 이하 입력 등 입금 처리 실패
     */
    @Override
    public boolean execute(int money) {
        // 1. 입금 금액이 0 이하(음수 또는 0)이면 입금은 허용되지 않음
        if (money <= 0) {
            return false; // 실패 반환(입금 불가)
        }

        // 2. 현재 user의 잔액(balance)에 입금할 금액을 더함 (실제 입금 처리)
        long prevBalance = user.getBalance(); // 입금 전 잔액(디버그용 변수)
        long newBalance = prevBalance + money; // 입금 후 예상 잔액

        user.setBalance(newBalance); // User 객체의 잔액 필드 업데이트

        // 3. 입금 처리 성공 반환
        return true;
    }
}
