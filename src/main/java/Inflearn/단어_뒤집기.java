package Inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 단어_뒤집기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        
        solution(n, str);
    }

    private static void solution(int n, String[] str) {
        ArrayList<String> array = new ArrayList<>();

        for (String s : str) {
            char[] c = s.toCharArray();

            for (int i = 0; i < c.length / 2; i++) {
                char temp = c[i];
                c[i] = c[c.length - i - 1];
                c[c.length - i - 1] = temp;
            }

            String tmp = String.valueOf(c);
            array.add(tmp);
        }
    }
}
