package ex_work;

public class Ex1_work {
    public static void main(String[] args) {
        
    //나이가 15세 이상이거나, 키가150cm이상이면 탑승가능
    //그렇지 않으면 탑승불가를 출력
    
    int age = 14;
    int height = 160;

    String res = "";

    if(age >=15 || height >=150){
       res= "탑승가능";
    }else{
        res = "탑승불가";
    }
  
    System.out.println(res);




    }//main
}
