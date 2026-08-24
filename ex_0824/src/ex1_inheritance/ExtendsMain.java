package ex1_inheritance;

public class ExtendsMain {
    public static void main(String[] args) {
        
        Child c1 = new Child(  ); 
        System.out.println(c1.car);

        //상속관계의 객체들에서 자식클래스는
        //부모가 가진 속성이나 메서드를 마음대로 가져다 쓸 수 있다.
        System.out.println(c1.money);
        System.out.println(c1.str);

        Parent p1 = new Parent();
        //부모객체는 자식객체의 속성을 가져다 쓸 수 없다.
        //System.out.println(p1.car);

        if(c1 instanceof Parent){
            System.out.println("c1은 Parent의 자식");
        }

    }//main
}
