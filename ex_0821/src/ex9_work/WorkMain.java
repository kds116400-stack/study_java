package ex9_work;

public class WorkMain {
    public static void main(String[] args) {
        
        //1~45사이의 중복되지 않는 난수 6개를 출력하는
        //로또번호 생성기 만들기
        int[] lotto = new int[6];
        

        WorkSub ws = new WorkSub();
        ws.myLotto(lotto);

        for( int i = 0; i < lotto.length; i++){
            System.out.print(lotto[i] + " ");
        }
            
    }//main
}
