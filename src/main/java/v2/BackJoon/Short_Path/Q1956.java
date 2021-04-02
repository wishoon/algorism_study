package v2.BackJoon.Short_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1956 {

    static int V;
    static int E;
    static int[][] graph;
    static int INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[V + 1][V + 1];
        INF = V * E + 1;

        for (int i = 0; i < V + 1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a = 1; a <= V; a++) {
            for (int b = 1; b <= V; b++) {
                if (a == b)
                    graph[a][b] = 0;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int a = 1; a <= V; a++) {
                for (int b = 1; b <= V; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int ans = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }

                // 자기 자신을 제외한 두 정점이
                // 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.
                if (graph[i][j] != INF && graph[j][i] != INF) {
                    ans = Math.min(ans, graph[i][j] + graph[j][i]);
                }
            }
        }

        if(ans == INF)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
