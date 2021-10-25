package v3.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int[] alpha = new int[26];

        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'A'] += 1;
        }

        int max = 0;
        char answer = '?';
        for (int i = 0; i < alpha.length; i++) {
            if(max < alpha[i]) {
                max = alpha[i];
                answer = (char) (i + 'A');
            } else if(alpha[i] == max) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}
