package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579 {

    static int N;
    static int[] stairs;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        dp = new Integer[N+1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if(N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        System.out.println(dp_stair(N));
    }

    public static int dp_stair(int depth){

        if(dp[depth] == null){
            dp[depth] = Math.max(dp_stair(depth - 2), dp_stair(depth - 3) + stairs[depth - 1]) + stairs[depth];
        }

        return dp[depth];
    }
}
