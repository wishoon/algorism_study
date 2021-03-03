package BackJoon.Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q10217 {
    static int T;
    static int N;
    static int M;
    static int K;

    static ArrayList<ArrayList<Node>> graph;
    static int[][] dp;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());   // M원 이하로 사용해야 한다.
            K = Integer.parseInt(st.nextToken());

            dp = new int[101][101];

            for (int k = 0; i < 101; i++) {
                Arrays.fill(dp[k], INF);
            }

            graph = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.get(u).add(new Node(v, c, d));

                dijkstra(1);

                sb.append(dp[N][0]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));
        dp[start][start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int distance = node.distance;
            int price = node.price;

            if(dp[now][0] < distance)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int dist = graph.get(now).get(i).getDistance();
                int cost = graph.get(now).get(i).getPrice();
                if(dist < dp[graph.get(now).get(i).getIndex()][0] && cost + dp[graph.get(now).get(i).getIndex()][1] <= M){
                    dp[graph.get(now).get(i).getIndex()][0] = dist;
                    dp[graph.get(now).get(i).getIndex()][1] += cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), dist, dp[graph.get(now).get(i).getIndex()][1]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        private int index;
        private int distance;
        private int price;

        public Node (int index, int distance, int price) {
            this.index = index;
            this.distance = distance;
            this.price = price;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance < o.distance)
                return -1;

            return 1;
        }
    }
}
