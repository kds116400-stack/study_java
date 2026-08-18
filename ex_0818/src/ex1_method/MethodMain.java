package ex1_method;

public class MethodMain {
    public static void main(String[] args) {
        
        MethodTest m1 = new MethodTest();
        m1.test1();

        int su = 100;
        su = m1.test2( su );

        System.out.println("su : " + su);
    }//main
}
