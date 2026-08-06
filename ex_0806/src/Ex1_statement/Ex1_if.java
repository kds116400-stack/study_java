package Ex1_statement;

public class Ex1_if {

    public static void main(String[] args) {

        // 제어문 - 프로그램의 흐름을 제어하는 문장
        // 분기문과 반복문으로 나뉜다
        // 분기문: it, switch
        // 반복문: for, while, d0-while

        // if문
        // if(조건식){
        // 조건식이 참일 때 실행되는 영역
        // }

        int n = 49; // n 변수에 49를 저장

        // String은 쌍따옴표 안에 여러글자(문자열)를 저장하기 위한 자료형
        String str = ""; // str 변수를 빈 문자열로 초기화

        // n이 50과 같으면 str에 "n은 50입니다"를 저장
        if (n == 50) {
            str = "n은 50입니다";
        }

        // n이 50과 다르면 str에 "n은 50이 아닙니다"를 저장
        if (n != 50) {
            str = "n은 50이 아닙니다";
        }

        System.out.println(str); // str 변수의 값을 콘솔에 출력

    }

}