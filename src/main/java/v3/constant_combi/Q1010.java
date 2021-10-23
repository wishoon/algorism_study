package v3.constant_combi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010 {

    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // nCr
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // mCn

            sb.append(bc(m ,n)).append("\n");
        }
        System.out.print(sb);
    }

    // 이항계수 공식을 이용한 풀이
    public static int bc(int m, int n) {

        if(dp[m][n] != 0) {
            return dp[m][n];
        }

        if(m == n || n == 0) {
            return dp[m][n] = 1;
        }


        return dp[m][n] = bc(m - 1, n - 1) + bc(m - 1, n);
    }
}
