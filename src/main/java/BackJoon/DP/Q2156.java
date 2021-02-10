package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];

        if(n > 1){
            dp[2] = arr[1] + arr[2];
        }
        System.out.println(recur(n));
    }

    public static int recur(int depth){
        if(dp[depth] == null){
            dp[depth] = Math.max(Math.max(recur(depth - 2), recur(depth - 3) + arr[depth - 1]) + arr[depth], recur(depth - 1));
        }

        return dp[depth];
    }
}
