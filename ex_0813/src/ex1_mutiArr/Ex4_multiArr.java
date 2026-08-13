package ex1_mutiArr;

public class Ex4_multiArr {
    public static void main(String[] args) {

        char[][] cArr = new char[2][];
        cArr[0] = new char[2];
        cArr[1] = new char[3];

        cArr[0][0] = '안';
        cArr[0][1] = '녕';

        cArr[1][0] = '하';
        cArr[1][1] = '세';
        cArr[1][2] = '요';

        for(int i = 0; i < cArr.length; i++){
            
            for(int j = 0; j < cArr[i].length; j++){

                System.out.print(cArr[i][j]);

            }//inner

            System.out.println();

        }//outrt                


    }// main
}
