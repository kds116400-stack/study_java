package ex3_construtor;

public class Pen {

    private String name;
    private int price;
    private String color;
    private boolean limited;

    public Pen() {
        //limited를 파라미터로 받는 생성자
        this(false);
    }

    // 한정판 생성을 위한 오버로딩 생성자
    public Pen(boolean limited) {
        this.limited = limited;

        if (limited) {// limited == true
            name = "모나미153-G";
            price = 20000;
            color = "금색";

        } else {
            name = "모나미153";
            price = 500;
            color = "흰색";

        }
    }

    public void info() {
        System.out.println("이름 : " + name);
        System.out.println("가격 : " + price);

        if(!limited){//lemited == false
        System.out.println("일반판 / " + color);
        }else{
            System.out.println("한정판 / " + color);
        }
        
        System.out.println("-------------");
    }

}
