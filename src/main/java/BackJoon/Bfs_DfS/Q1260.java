package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {

    public static int N;
    public static int M;
    public static int V;
    public static int[][] graph;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 1. 정점의 개수, 2. 간선의 개수 3. 탐색을 시작할 정점의 번호
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y  = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        dfs(V);
        System.out.println();
        visit = new boolean[N + 1];
        bfs(V);
    }


    public static void dfs(int v){

        if(!visit[v]){
            visit[v] = true;
            System.out.print(v + " ");
            for(int i = 1; i <= N; i++){
                if(graph[v][i] == 1 && !visit[i]){
                    dfs(i);
                }
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> q  = new LinkedList<>();
        q.offer(v);
        visit[v] = true;
        System.out.print(v + " ");
        while (!q.isEmpty()){
            v = q.poll();
            for(int j = 1; j <= N; j++){
                if(graph[v][j] == 1 && !visit[j]){
                    q.offer(j);
                    visit[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
