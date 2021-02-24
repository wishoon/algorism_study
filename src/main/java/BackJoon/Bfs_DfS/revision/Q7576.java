package BackJoon.Bfs_DfS.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q7576 {

    static int M;
    static int N;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();
    }

    public static void bfs () {

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1)
                    queue.offer(new Node(j, i));
            }
        }

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            for (int i = 0; i < 4; i++) {

                int curx = temp.x + dx[i];
                int cury = temp.y + dy[i];

                if(curx < 0 || cury < 0 || curx >= M || cury >= N){
                    continue;
                }

                if(arr[cury][curx] == 0) {
                    queue.offer(new Node(curx, cury));
                    arr[cury][curx] = arr[temp.y][temp.x] + 1;
                    answer = arr[cury][curx];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer - 1);
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
