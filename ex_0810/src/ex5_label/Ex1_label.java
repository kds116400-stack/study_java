package ex5_label;

public class Ex1_label {
    public static void main(String[] args) {

        // 특정 반복문에 label을 붙여
        // 한 번에 두 개 이상의 반복문을 제어할 수 있다.
        out : for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 10; j++) {

                if (j % 2 == 0)
                    //out이라는 label을 가진
                    //바깥쪽 for문을 빠져나간다
                    break out;

                System.out.print(j + " ");

            } // inner

            System.out.println();

        } // out

    }// main
}
