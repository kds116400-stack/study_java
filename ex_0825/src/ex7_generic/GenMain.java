package ex7_generic;

public class GenMain {
    public static void main(String[] args) {

        GenTest<String> g1 = new GenTest<String>();
        g1.setValue("안녕");
        String res = g1.getValue();
        System.out.println("g1 : " + res);

        GenTest<Integer> g2 = new GenTest<>();
        g2.setValue(100);
        int res2 = g2.getValue();
        System.out.println("g2 : " + res2);

    }// main
}
