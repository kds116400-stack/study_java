package ex1_set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ex1_Set {
    public static void main(String[] args) {

        // collection :
        // 많은 수의 데이터를 그 사용 목적에 적합한 구조로 묶어서
        // 하나로 그룹화 한 객체
        // ---------------
        // Set, Map, List 3 2 1

        // Set java.util패키지의 인터페이스다.
        // 특정 코드에서 중복된 값의 허용이 있어서는 안될 때 사용
        // 복잡한 코드없이 중복요소를 빠르게 제가할 수 있다.

        // Set인터페이스를 구현하고 있는 대표적인 자식클래스
        // HashSet : 정렬이 안됨
        // TreeSet : 오름차순 정렬
        Set<Integer> Set = new HashSet<Integer>();
        Set.add(150);
        Set.add(70);
        Set.add(10);
        Set.add(200);
        
        //중복된 값은 추가하지 않는다
        Set.add(10);

        //Set의 모든 내여을 비운다
        Set.clear();

        System.out.println("set의 크기 : " + Set.size());
        System.out.println(Set);

        System.out.println("------------");

        Set<Integer> Set2 = new HashSet<Integer>();
        Random rnd = new Random();

        while(true){

            int r = rnd.nextInt(6) + 1;
            Set2.add(r);

            if( Set2.size() == 6 ){
                break;
            }

        }//while

        System.out.println(Set2);

        //set2를 배열로 변환
        Integer[] arr = Set2.toArray(new Integer[0]);

        for( int i = 0; i < arr.length; i++ ){
            System.out.print(arr[i] + " ");
        }//for

        System.out.println("-----------------");

        int[] arr2 = new int[Set2.size()];
        int i = 0;
        for(Integer num : Set2){
            arr2[i++] = num;
           
        }

        for(int j = 0; j < arr2.length; j++){
            System.out.print(arr[j] + " ");
        }

    }// main
}
