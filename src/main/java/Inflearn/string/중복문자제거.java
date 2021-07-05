package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복문자제거 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }

    private static String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            // 현재의 인덱스와 문자 중에서 최초로 특정문자가 있는 위치가 일치 할 경우는 중복 단어가 없다는 의미
            if(i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }
}
