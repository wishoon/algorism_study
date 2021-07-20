package Inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장_짧은_문자거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");


        int[] answer = solution(input[0], input[1]);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
    
    public static int[] solution(String s, String t){
        char[] c = s.toCharArray();

        int[] answer = new int[c.length];

        for (int i = 0; i < c.length; i++) {
            answer[i] = 100;
        }

        for (int i = 0; i < c.length; i++) {

            for (int j = 0; j < c.length; j++) {

                if(c[j] == t.charAt(0)) {
                    if(i == j) {
                        answer[i] = 0;
                    } else {
                        answer[i] = Math.min(answer[i], Math.abs(i - j));
                    }
                }
            }
        }

        return answer;
    }
}
