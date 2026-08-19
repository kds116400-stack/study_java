package ex5_work;

public class Calsub {

    public int getResult(int su1, int su2, String op){
        
        switch (op) {
            case  "+" :
                return su1 + su2;
            case "-":
               
                return su1 - su2;
            case "*":
                
                return su1 * su2;
            case "/":
               
                return su1 / su2;

            default :
            System.out.println("연산기호가 올바르지 않습니다");
            return -1;
        }
            
        }
}
