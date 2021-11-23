package v2.Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 합승_택시_요금 {

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        // 지점의 갯수 n, 출발 지점을 나타내는 s, A의 도착지점을 나타내는 a, B의 도착지점을 나타내는 b, 지점사이의 예상 요금 fares
        int answer = 0;

        int[][] graph = new int[n + 1][n + 1];
        int INF = 100000;

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];

            graph[c][d] = f;
            graph[d][c] = f;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++)
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);

        return answer;
    }
}
