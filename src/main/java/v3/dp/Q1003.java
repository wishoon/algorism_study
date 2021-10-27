package v3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {

    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            fibo(n);
            sb.append(dp[n][0] + " " + dp[n][1]).append("\n");
        }

        System.out.print(sb);
    }

    public static Integer[] fibo(int n) {

        // N에 대해서 0과 1을 방문 한적이 없는 경우 (방문 체크 때문에 Integer 로 변경)
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            dp[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }

        return dp[n];
    }
}
