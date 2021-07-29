package BackJoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11726 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        System.out.println(tile(n));;
    }

    private static int tile(int n) {

        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        if(dp[n] > 0) {
            return dp[n];
        }

        dp[n] = tile(n - 2) + tile(n - 1);
        dp[n] %= 10007;

        return dp[n];
    }
}
