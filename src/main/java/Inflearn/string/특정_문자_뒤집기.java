package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 특정_문자_뒤집기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }

    private static String solution(String str) {

        char[] c = str.toCharArray();

        for (int i = 0; i < c.length / 2; i++) {
            char temp = c[i];

            if(Character.isAlphabetic(temp)) {
                c[i] = c[c.length - i - 1];
                c[c.length - i - 1] = temp;
            } else {
                continue;
            }
        }
        String tmp = String.valueOf(c);

        return tmp;
    }
}
