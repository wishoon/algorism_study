package v3.programmers;

import java.util.Arrays;

public class 합승_택시_요금 {
    public static void main(String[] args) {
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
         int INF = 20000000;
         int answer = INF;

         int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            graph[start][end] = cost;
            graph[end][start] = cost;
        }

        // 플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
           answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }

        return answer;
    }
}
