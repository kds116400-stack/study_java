package ex5_abstract;

abstract public class AbsParent {
    
    int value = 100;

    public int getValue(){
        return value;
    }

    //추상메서드 : 메서드의 몸체(body)가 없는
    //'미완성개념'의 메서드
    //상속관계에서 자식이 받아서 완성시키는 것을 조건
    abstract public void setValue(int n);
    
}
