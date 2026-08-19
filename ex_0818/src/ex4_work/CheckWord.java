package ex4_work;

public class CheckWord {

    public String check(String str) {

        // 원본을 뒤집어서 저장할 객체
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        } // for

        return rev;

    }

}
