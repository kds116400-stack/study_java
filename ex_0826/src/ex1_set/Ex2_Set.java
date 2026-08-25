package ex1_set;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ex2_Set {
    public static void main(String[] args) {
        
        TreeSet<Integer> ts = new TreeSet<Integer>();
        Random rnd = new Random();

        while(ts.size() < 6){

            int r = rnd.nextInt(45) + 1 ;
            ts.add(r);

        }//while

        System.out.println(ts);
        System.out.println(ts.subSet(10, 30));

        System.out.println("----------------");

        Set<String> Set = new TreeSet<String>(); 
        Set.add("홍길동");
        Set.add("강길순");
        Set.add("공봉민");
        System.out.println(Set);
    }//main
}
