package ex3_list;

import java.util.ArrayList;
import java.util.List;

public class Ex1_List {
    public static void main(String[] args) {
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(100);
        list.add(50);
        list.add(1,60);
        list.set(0, 90);
        list.remove(2);

        if( list.contains(50) ){
            System.out.println("list에 50이 있다");
        }

        System.out.println("size : " + list.size());
        System.out.println(list);
        System.out.println("2번 index값 : " + list.get(2));

        list.clear();
        System.out.println("size : " + list.size());



    }//main
}
