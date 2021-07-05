package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만_추출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        solution(str);
    }

    private static void solution(String str) {
        int answer = 0;
        for (char c : str.toCharArray()) {
            if(c >= 48 && c <= 57)
                answer = answer * 10 + (c - 48);
        }

        System.out.println(answer);
    }

}
