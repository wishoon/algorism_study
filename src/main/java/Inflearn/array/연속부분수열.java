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

        int r = 0;
        int l = 0;
        int sum = 0;
        int answer = 0;

        while(l < n && r < n) {
            if(sum == m) {
                answer++;
                sum -= Integer.parseInt(arr[l]);
                l++;
                continue;
            } else if (sum > m) {
                sum -= Integer.parseInt(arr[l]);
                l++;
            } else {
                sum += Integer.parseInt(arr[r]);
                r++;
            }
        }
        return answer;
    }
}
