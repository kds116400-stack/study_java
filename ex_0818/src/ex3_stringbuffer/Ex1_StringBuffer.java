package ex3_stringbuffer;

public class Ex1_StringBuffer {
    public static void main(String[] args) {
        
        String str = "안녕"; //집생성
        str = "반갑습니다";  // 안녕은 사라지지않음(메모리에는 있음)
        str += "!"; //반갑습니다 + ! 추가생성
        System.out.println(str);

        StringBuffer sb = new StringBuffer("안녕");
        sb.setLength(0);
        sb.append("반가워요");
        sb.append("!!!");
        System.out.println(sb.toString());
    }//main
}
