package ex2_constructor;

public class Pokemon {
    
    private String name;
    private int hp;
    private String type;

    public Pokemon(String name, String type){ 
        this.name = name;
        this.type = type;
        hp = 100;


    }

    public void info(){
        System.out.println("이름 : " + name);
        System.err.println("타입 : " + type);
        System.out.println("체력 : "+ hp);
        System.out.println("------");
        
        
        
        
    }
    
    // name의 setter
    public void setName(String name) {
        this.name = name;
    }
       
    
    // hp의 setter
    public void setHp(int hp) {
        this.hp = hp;
    }
    
}
