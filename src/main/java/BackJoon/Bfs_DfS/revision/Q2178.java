package BackJoon.Bfs_DfS.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {

    static int N;
    static int M;
    static int[][] arr;
    static Integer[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new Integer[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(visit[N-1][M-1]);
    }

    public static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visit[0][0] = 1;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int val = visit[temp.y][temp.x];
            for (int i = 0; i < 4; i++) {
                int curx = temp.x + dx[i];
                int cury = temp.y + dy[i];

                if(curx < 0 || cury < 0 || curx >= M || cury >= N){
                    continue;
                }
                if(visit[cury][curx] == null && arr[cury][curx] == 1) {
                    queue.offer(new Node(curx, cury));
                    visit[cury][curx] = val + 1;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
