package ex2_set_get;

public class Person2 {
    
    private String name;
    private int age;

    public void setInfo(String name, int age){
        //this : 현재 클래스 자신
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

}
