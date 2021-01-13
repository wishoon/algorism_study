package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1012_2 {

    public static int T;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int M;
    public static int N;
    public static int K;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                arr[p2][p1] = 1;
            }

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (arr[x][y] == 1 && !visited[x][y]) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int i, int j){

        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {i, j});

        while(!q.isEmpty()){

            int curY = q.peek()[0];
            int curX = q.peek()[1];

            q.poll();

            if(curX < 0 || curY < 0 || curX >= M || curY >= N)
                continue;

            if(visited[curY][curX] || arr[curY][curX] != 1 )
                continue;

            if(!visited[curY][curX]){
                visited[curY][curX] = true;

                q.offer(new int[] {curY - 1, curX});
                q.offer(new int[] {curY + 1, curX});
                q.offer(new int[] {curY, curX - 1});
                q.offer(new int[] {curY, curX + 1});
            }
        }
    }
}
