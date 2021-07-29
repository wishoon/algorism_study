package BackJoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());

        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        // 여기서 체크하는 로직을 수행
        System.out.println(Math.min(led_check(N - 1, 0), Math.min(led_check(N - 1, 1), led_check(N - 1, 2))));

    }

    private static int led_check(int depth, int color) {

        if(dp[depth][color] == 0) {

            if(color == 0) {
                dp[depth][0] = Math.min(led_check(depth - 1, 1), led_check(depth - 1, 2)) + arr[depth][0];
            } else if(color == 1) {
                dp[depth][1] = Math.min(led_check(depth - 1, 0), led_check(depth - 1, 2)) + arr[depth][1];
            } else if(color == 2) {
                dp[depth][2] = Math.min(led_check(depth - 1, 0), led_check(depth - 1, 1)) + arr[depth][2];
            }
        }

        return dp[depth][color];
    }


}
