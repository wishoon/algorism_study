package Inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m, n;
    static int[][] tomato;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();


        dist = new int[n][m];
        tomato = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());

                if(tomato[i][j] == 1) {
                    queue.offer(new Node(i, j));
                }
            }
        }
        bfs(queue);
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tomato[i][j] == 0) {
                    System.out.println(i + " " + j);
                    flag = false;
                }

            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dist[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs(Queue<Node> queue) {

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = node.y + dy[i];
                int nextX = node.x + dx[i];

                if(nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }
                if(tomato[nextY][nextX] == -1 || tomato[nextY][nextX] == 1) {
                    continue;
                }
                tomato[nextY][nextX] = 1;
                dist[nextY][nextX] = dist[node.y][node.x] + 1;
                queue.offer(new Node(nextY, nextX));
            }
        }
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
