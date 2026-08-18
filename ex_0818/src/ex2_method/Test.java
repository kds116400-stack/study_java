package ex2_method;

public class Test {

    public String average(int su1, int su2, int su3) {

        int num = su1 + su2 + su3 / 3;

        if (num > 50) {
            return "합격";
        } else {
            return "불합격";
        }

    }

}
