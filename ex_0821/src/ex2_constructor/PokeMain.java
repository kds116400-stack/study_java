package ex2_constructor;

public class PokeMain {
    
    // INSERT_YOUR_CODE
    // Pokemon 클래스의 멤버 변수들의 setter 생성
    // (Pokemon 클래스의 변수는 현재 private이므로 setter로 접근해야 함)
    // 아래 관계에 의해 main 코드도 setter를 사용해야 정상 동작합니다.

    
    
    public static void main(String[] args) {
        
        //이름과 타입을 반드시 입력해야만 객체가 생성되도록 강제
        //필수정보가 빠진 포켓몬이 만들어지는것을 방지할 수있다.

        Pokemon p1 = new Pokemon("피카츄", "전기");
        p1.setName("라이츄");
        p1.info();

    }//main
}
