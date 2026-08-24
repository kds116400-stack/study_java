package ex2_inheritance;

public class Snake extends Animal {
    
    String merit = "밤에도 잘봄";

    //오버라이드 : 메서드의 재 정의
    //상속관계의 객체에서 부모의 함수를 자식이 가져와
    //자식 사정에 맞도록 내용만 재정의 하는 것
   @Override
   public int getLeg() {
        return 0;
   }

}
