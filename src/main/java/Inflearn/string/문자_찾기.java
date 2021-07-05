package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char c = br.readLine().charAt(0);

        solution(str, c);
    }

    public static int solution(String str, char c) {
        int answer = 0;

        str = str.toUpperCase();    // string이 다 대문자로 변경
        c = Character.toUpperCase(c);   // char을 대문자로 변경

        // 방법 1.
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                answer++;
            }
        }
        System.out.println(answer);
        answer = 0;
        // 방법 2.
        for (char i : str.toCharArray()) {
            if(i == c) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
