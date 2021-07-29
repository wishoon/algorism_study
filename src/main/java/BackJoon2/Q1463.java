package BackJoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Top-Down, Up-Down으로 한 번 더 풀어보기

public class Q1463 {
    static int N;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];

        dp[0] = dp[1] = 0;

        System.out.println(recur(N));
    }

    private static int recur(int n) {

        if(dp[n] == null) {
            if(N % 6 == 0) {
                dp[n] = Math.min(recur(n / 3), Math.min(recur(n / 2), recur(n - 1))) + 1;
            } else if(N % 3 == 0) {
                dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
            } else if(N % 2 == 0) {
                dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
            } else {
                dp[n] = recur(N - 1) + 1;
            }
        }

        return dp[n];
    }
}
