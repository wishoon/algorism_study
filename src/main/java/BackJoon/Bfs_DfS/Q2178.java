package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static int N;
    public static int M;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

    public static void bfs(int y, int x){

        Queue<int[] > q = new LinkedList<>();
        q.offer(new int[] {y, x});

        while(!q.isEmpty()){
            int curX = q.peek()[1];
            int curY = q.peek()[0];

            visited[curY][curX] = true;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = curX + dx[i];
                int moveY = curY + dy[i];
                if(moveX < 0 || moveY < 0 || moveX >= M || moveY >= N)
                    continue;
                if(arr[moveY][moveX] != 1 || visited[moveY][moveX])
                    continue;

                if(arr[moveY][moveX] == 1 && !visited[moveY][moveX]){

                    q.offer(new int[] {moveY, moveX});

                    visited[moveY][moveX] = true;
                    arr[moveY][moveX] = arr[curY][curX] + 1;
                }
            }
        }
    }
}
