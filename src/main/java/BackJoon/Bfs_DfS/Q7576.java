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
    public static int H;
    public static int[][] tomoto;
    public static boolean[][] visited;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int count = Integer.MIN_VALUE;

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
        bfs();
    }

    public static void bfs(){

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomoto[i][j] == 1)
                    q.offer(new int[] {i, j});
            }
        }
        while (!q.isEmpty()){

            int curX = q.peek()[1];
            int curY = q.peek()[0];

            q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
                    continue;

                if(tomoto[nextY][nextX] != 0)
                    continue;

                tomoto[nextY][nextX] = tomoto[curY][curX] + 1;

                q.offer(new int[] {nextY, nextX});
            }
            // 익은 토마토의 상하좌우는 1일 뒤에 익기 때문에 큐에 담는다.
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomoto[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                count = Math.max(count, tomoto[i][j]);
            }
        }
        System.out.println(count - 1);
    }
}
