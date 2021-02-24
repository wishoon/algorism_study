package BackJoon.Bfs_DfS.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1260 {

    static int N;
    static int M;
    static int V;
    static int[][] arr;
    static int[][] dfs_arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        arr = new int[N+1][N+1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arr[x][y] = arr[y][x] = 1;
        }
        dfs(V);
        System.out.println();
        visit = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(int n) {

        if(!visit[n]) {
            visit[n] = true;
            System.out.print(n + " ");
            for (int i = 1; i <= N; i++) {

                if(arr[n][i] == 1 && !visit[i]) {
                    dfs(i);
                }
            }
        }
    }

    private static void bfs(int n) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visit[n] = true;
        System.out.print(n + " ");
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 1; i <= N; i++) {
                if(arr[temp][i] == 1 && !visit[i]){
                    queue.offer(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }

    }

    private static void initialize() {
    }
}
