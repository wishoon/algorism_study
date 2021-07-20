package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수_에라토스로_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            if(arr[i] == 0) {
                answer++;
                for (int j = i; j < n + 1; j=j+i) {
                    arr[j] = 1;
                }
            }
        }
        return answer;
    }
}
