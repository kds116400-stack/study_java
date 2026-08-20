package ex01_work;

public class NumSub {
    
    public boolean isNumber(String str){

        for(int i = 0; i < str.length(); i++){

        
            char ch= str.charAt(i);

            //       48          57
            if(ch < '0' || ch > '9'){
                return false;
                //아스키코드 숫자는 48 47
                // 알파벳은 64
            }

        }//for

        return true;

        
    }

}
