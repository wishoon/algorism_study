package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        if(num == 1) {
            System.out.println(1);
        } else if(num == 2) {
            System.out.println(1 + " " + 1);
        } else {
            System.out.println(solution(num));
        }
    }

    private static String solution(int num) {

        StringBuilder sb = new StringBuilder();

        int[] answer = new int[num];

        answer[0] = 1;
        answer[1] = 1;

        sb.append(1 + " " + 1);

        for (int i = 2; i < answer.length; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
            sb.append(" " + answer[i]);
        }

        return sb.toString();
    }

}
