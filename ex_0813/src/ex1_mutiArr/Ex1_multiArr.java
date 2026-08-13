package ex1_mutiArr;

public class Ex1_multiArr {
    public static void main(String[] args) {

        int[][] test = new int[2][3]; // t0 y t1 y
                                      // tt012 x tt012 x
                                      // 100 200 300 400 500 600
                                      // 100 200 300
                                      // 400 500 600
        test[0][0] = 100;
        test[0][1] = 200;
        test[0][2] = 300;

        test[1][0] = 400;
        test[1][1] = 500;
        test[1][2] = 600;

        for (int i = 0; i < test.length; i++) { // i < 2

            for (int j = 0; j < test[i].length; j++) { // j < 3

                System.out.print(test[i][j] + " ");

            } // inner

            System.out.println();

        } // outer

    }// main
}
