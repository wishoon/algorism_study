package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1149 {

    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(cost_ck(N - 1, 0), Math.min(cost_ck(N - 1, 1), cost_ck(N - 1, 2))));
    }

    public static int cost_ck(int N, int index){

        if(dp[N][index] == 0) {
            // color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해 dp에 저장
            if(index == 0){
                dp[N][index] = Math.min(cost_ck(N - 1, 1), cost_ck(N-1, 2)) + cost[N][0];
            }
            else if(index == 1) {
                dp[N][index] = Math.min(cost_ck(N - 1, 0), cost_ck(N - 1, 2)) + cost[N][1];
            }
            else {
                dp[N][index] = Math.min(cost_ck(N - 1, 0), cost_ck(N - 1, 1)) + cost[N][2];
            }
        }

        return dp[N][index];
    }
}
