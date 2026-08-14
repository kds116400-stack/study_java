public class Ex01_work {
    public static void main(String[] args) {
        
        // 과수원이 있다.
        //배,사과,오렌지를 키우고 있는데, 하루에 생산되는 양이
        //각각 5, 7 ,5개.

        //1.과수원에서 하루에 생산되는 과일의 총 갯수를 출력
        //2.시간당 전체 과일의 평균 생산 갯수
        //단, 과일의 갯수를 담는 변수는 inr, 평윤을 계산할 변수는 float

        int pear = 5;
        int apple = 7;
        int orange = 5;

        int total = pear + apple + orange;
        System.out.println("하루생산량 : " + total);

        float avg = total / 24f;
        //System.out.println("하루 시간 당 평균 : " + avg);
        System.out.printf("시간당 평균 : %.2f",avg);


    }//main
}
