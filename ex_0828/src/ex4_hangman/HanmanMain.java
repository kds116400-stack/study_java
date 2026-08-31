package ex4_hangman;

import java.util.Random;

public class HanmanMain {

    public static void main(String[] args) {

        // *** HangMan ***
        // Word : ☆☆☆☆☆ >> a
        // Word : a☆☆☆☆ >> a
        // a은(는) 이미 입력한 문자입니다
        // Word : a☆☆☆☆ >> e
        // Word : a☆☆☆e >> o
        // o이(가) 포함되어 있지 않습니다
        // Word : a☆☆☆e >> p
        // Word : app☆e >> abc
        // 한글자의 영 소문자만 입력 가능합니다
        // Word : app☆e >> l
        // apple 정답
        // 7회 만에 정답

        String[] word = { "apple", "game" };
        int rnd = new Random().nextInt(word.length);

        PlayGame pg = new PlayGame();
        pg.play(word[rnd]);

    }
}