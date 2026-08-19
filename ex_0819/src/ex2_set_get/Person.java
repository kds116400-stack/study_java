package ex2_set_get;

public class Person {
    
    private String gender;

    public void setGender( String s){
        gender = s;
    }

    public String getGender(){
        return gender;
    }



    private String name;
    
    public void setName( String n ){
        name = n;
    }

    public String getName(){
        return name;
    }

    private int age;

    public int getAge(){
        return age;
    }

    public void setAge( int a){
        age = a;
    }

}
