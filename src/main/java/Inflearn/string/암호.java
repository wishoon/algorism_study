package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();

        System.out.println(solution(n, input));
    }

    private static String solution(int n, String input) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = input.substring(0, 7)
                            .replace('#', '1')
                            .replace('*', '0');

            int num = Integer.parseInt(s, 2);
            sb.append((char)num);
            input = input.substring(7);
        }

        return sb.toString();
    }
}
