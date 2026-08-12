package ex5_label;

public class Ex3_label {
    public static void main(String[] args) {

        outer: for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 5; j++) {
                
                if (i % 2 == 0) {
                    continue outer;
                } // if

                System.out.print(j + " ");

            } // inner

            System.out.println();

        } // outer

    }// main
}
