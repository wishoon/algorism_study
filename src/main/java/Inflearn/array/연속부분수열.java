package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        String[] arr = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, String[] arr) {

        int lt = 0;
        int sum = 0;
        int answer = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += Integer.parseInt(arr[rt]);

            if(sum == m) {
                answer++;
            }
            while(sum >= m) {
                sum -= Integer.parseInt(arr[lt++]);
                if(sum == m) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
