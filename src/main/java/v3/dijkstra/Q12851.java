package v3.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q12851 {
    static int[] move = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, K = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

       bfs(N, K);
    }

    public static void bfs(int n, int k) {
        int min = 0;
        int cnt = 0;
        int[] visited = new int[100001];
        int[] time = new int[100001];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));
        visited[n] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur_place = node.place;
            int cur_time = node.time;


            if(cur_place == k){
                min = cur_time;
                cnt++;
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int next_place, next_time;
                if(i == 2) {
                    next_place = cur_place * move[i];
                    next_time = cur_time + 1;
                } else {
                    next_place = cur_place + move[i];
                    next_time = cur_time + 1;
                }
                if(0 <= next_place && next_place <= 100000) {
                    if(visited[next_place] == 0) {
                        visited[next_place] = 1;
                        time[next_place] = time[cur_place] + 1;
                        queue.offer(new Node(next_place, next_time));
                    } else if(time[next_place] == time[cur_place] + 1){
                        time[next_place] = time[cur_place] + 1;
                        queue.offer(new Node(next_place, next_time));
                    }
                }
            }
        }

        System.out.println(min);
        System.out.println(cnt);
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
