package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 대문자로 변경시키고 정규식에 따라 대문자가 아니면 삭제해라
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        System.out.println(solution(str));
    }

    private static String solution(String str) {

        for (int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return "NO";
            }
        }
        return "YES";
    }
}
