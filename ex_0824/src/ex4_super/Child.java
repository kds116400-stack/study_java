package ex4_super;

public class Child extends Parent {
    
    public Child(){
        //부모클래스의 생성자
        super(10);
        System.out.println("자식클래스의 생성자");
    }

    @Override
    public int getNum() {
        super.num = 100; //부모의 num변수로 접근

        //부모의 getNum()메서드 호출
        return super.getNum();
    }

}
