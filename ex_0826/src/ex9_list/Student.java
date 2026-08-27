package ex9_list;

public class Student {
    
    private String name;
    private int kor;
    private int eng;
    
    private int total;
    private float avg;

    public Student( String name, int kor, int eng ){

        this.name = name;
        this.kor = kor;
        this.eng = eng;
        total = kor + eng;
        avg = total / 2f;

    }

    public float getAvg() {
        return avg;
    }

    public void studentInfo(){
        System.out.printf(
            "%s\t 국어 :  %d\t영어 : %d\t총점 : %d\t평균 : %.1f\n",
        name, kor, eng, total, avg);
    }

}
