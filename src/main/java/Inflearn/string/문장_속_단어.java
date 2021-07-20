package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문장_속_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));;
    }

    private static String solution(String str) {
        String answer = "";

        // 첫번째 방법
        String[] arr_str = str.split(" ");
        int min = 0;

        for (int i = 0; i < arr_str.length; i++) {
            if(arr_str[min].length() < arr_str[i].length()) {
                min = i;
            }
        }

        System.out.println(arr_str[min]);

        // 두번째 방법
        int m = Integer.MIN_VALUE;
        String[] arr_str2 = str.split(" ");
        for (String s : arr_str2) {
            int len = s.length();
            if(len > m) {
                m = len;
                answer = s;
            }
        }
        return answer;
    }
}
