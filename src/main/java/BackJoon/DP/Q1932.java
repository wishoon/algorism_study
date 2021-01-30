package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1932 {

    static int[][] triangle;
    static Integer[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(maxSum(0, 0));
    }

    public static int maxSum(int depth, int idx){
        if(depth == n - 1)
            return triangle[depth][idx];

        if(dp[depth][idx] == null){
            dp[depth][idx] = Math.max(maxSum(depth + 1, idx), maxSum(depth + 1, idx + 1)) + triangle[depth][idx];
        }
        return dp[depth][idx];
    }
}
