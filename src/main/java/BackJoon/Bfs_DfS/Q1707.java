package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1707 {
    static int T;   // 테스트 케이스의 수
    static int V;   // 그래프의 정점의 개수
    static int E;   // 그래프의 간선의 개수
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            color = new int[V];
            graph = new ArrayList<>();

            for (int j = 0; j < V; j++) {
                graph.add(new ArrayList<>());
            }

            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(b - 1).add(a - 1);
                graph.get(a - 1).add(b - 1);
            }

            for (int j = 0; j < V; j++) {
                if(color[j] == 0) {
                    color[j] = 1;
                    dfs(V, j);
                }
            }
            sb.append(check(V) + "\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int x, int y) {

        int c = color[y];
        for (int i = 0; i < graph.get(y).size(); i++) {
            int temp = graph.get(y).get(i);

            if(color[temp] == 0) {
                if(c == 1) {
                    color[temp] = -1;
                } else if(c == -1){
                    color[temp] = 1;
                }
                dfs(x, temp);
            }
        }
    }

    public static String check(int V) {

        for (int n = 0; n < V; n++) {
            for (int m = 0; m < graph.get(n).size(); m++) {
                if (color[n] == color[graph.get(n).get(m)]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
