package v3.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2665 {

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i + 1][j + 1] = str.charAt(j) - '0';
                dist[i + 1][j + 1] = Integer.MAX_VALUE;
            }
        }
        dijkstra(n, arr, dist);
    }

    public static void dijkstra(int n, int[][] arr, int[][] dist) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 1));
        dist[1][1] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur_y = node.y;
            int cur_x = node.x;

            System.out.println(cur_y + " " + cur_x);

            // 이미 방문한 값이 훨씬 더 큰 경우 이동 x
            for (int i = 0; i < 4; i++) {
                int next_y = cur_y + dy[i];
                int next_x = cur_x + dx[i];

                // 사각형 벗어나는 지 안 벗어나는지
                if (next_x <= 0 || next_x > n || next_y <= 0 || next_y > n) {
                    continue;
                }
                if(dist[cur_y][cur_x] >= dist[next_y][next_x]) {
                    continue;
                }
                if(arr[next_y][next_x] == 0) {
                    dist[next_y][next_x] = dist[cur_y][cur_x] + 1;
                } else {
                    dist[next_y][next_x] = dist[cur_y][cur_x];
                }
                queue.offer(new Node(next_y, next_x));
            }
        }

        System.out.println(dist[n][n]);
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
