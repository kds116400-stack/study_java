package ex6_work;

public class Gradesub {
    
    public int myPoint( String grade, int price ){

        if(grade.equalsIgnoreCase("vip")){
            return price * 10 / 100;

        }else if(grade.equalsIgnoreCase("gold")){
            return price * 5 / 100;

        }else if(grade.equalsIgnoreCase("silver")){

            return price * 3/100;
        
        }else{
            System.out.println("회원등급이 올바르지 않습니다");
            return 0;
        }
    }//myPoint()

}
