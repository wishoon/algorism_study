package v3.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13549 {

    static int[] move = {2, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, K;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N, K);

    }

    public static void bfs(int n, int k) {
        int[] visit = new int[100001];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));

        visit[n] = 1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int cur_place = node.place;
            int cur_time = node.time;


            if(cur_place == k) {
                System.out.println(cur_time);
                break;
            }
            for (int i = 0; i < 3; i++) {
                int next_place = 0, next_time = 0;
                if(i == 0) {
                    next_place = cur_place * move[i];
                    next_time = cur_time + 0;
                } else {
                    next_place = cur_place + move[i];
                    next_time = cur_time + 1;
                }

                if(next_place >= 0 && next_place <= 100000 && visit[next_place] == 0) {
                    visit[next_place] = 1;
                    queue.offer(new Node(next_place, next_time));
                }
            }
        }
    }

    static class Node {
        int place;
        int time;

        public Node(int place, int time) {
            this.place = place;
            this.time = time;
        }
    }
}
