package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {

    public static int M;
    public static int N;
    public static int[][] tomoto;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomoto = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                tomoto[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0, 0);
    }

    public static void bfs(int y, int x){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y, x});

        while (!q.isEmpty()){
            int curX = q.peek()[1];
            int curY = q.peek()[0];

            for (int i = 0; i < 4; i++) {
                int movX = curX + dx[i];
                int movY = curY + dy[i];

                if(movX < 0 || movY < 0 || movX < N || movY < M)
                    continue;
                if(tomoto[movY][movX] == 1 && visited[movY][movX])
                    continue;

                if(tomoto[movY][movX] == 0 && !visited[movY][movX]){

                    visited[movY][movX] = true;
                    tomoto[movY][movX] = 1;


                }
            }
        }
    }
}
