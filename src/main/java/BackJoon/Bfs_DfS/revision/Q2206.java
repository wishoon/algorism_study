package BackJoon.Bfs_DfS.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {

    static int N;
    static int M;
    static int ans = 0;
    static int[][] arr;
    static int[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        if(ans == 0)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, 0));

        while (!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.y == N - 1 && temp.x == M - 1){
                ans = temp.move;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int curx = temp.x + dx[i];
                int cury = temp.y + dy[i];

                if(curx < 0 || cury < 0 || curx >= M || cury >= N)
                    continue;

                if(visit[cury][curx] > temp.cnt) {
                    if(arr[cury][curx] == 0) {
                        queue.add(new Node(curx, cury, temp.move + 1, temp.cnt));
                        visit[cury][curx] = temp.cnt;
                    }
                    else if(arr[cury][curx] == 1) {
                        if(temp.cnt == 0){
                            queue.add(new Node(curx, cury, temp.move + 1,temp.cnt + 1));
                            visit[cury][curx] = temp.cnt + 1;
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int move;
        int cnt;

        public Node(int x, int y, int move, int cnt) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.cnt = cnt;
        }
    }
}
