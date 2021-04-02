package v2.BackJoon.Short_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q10217 {
    static int T, N, M, K;  // 테스트 케이스, 공항의 수, 총 지원비용, 티켓정보의 수
    static ArrayList<ArrayList<Node>> graph;
    static int[][] dist_cost;
    static int INF = 100 * 10000 + 1;

    public static void main(String[] args) throws IOException {
        /**
         * 각 공항들간 티켓가격과 이동시간이 주어질 때, 인천에서 LA로 갈 수 있는 가장 빠른 길을 찾자
         * 단, 공항들 간의 거리와 가격이 주어지고 이를 활용해서 풀어야 한다.*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());


            dist_cost = new int[N + 1][M + 1];  // N번의 공항까지 M만큼의 비용을 소모함.

            for (int j = 0; j <= N ; j++) {
                graph.add(new ArrayList<>());
                Arrays.fill(dist_cost[j], INF);
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.get(u).add(new Node(v, c, d));
            }

            int answer = dijkstra(1);
            if(INF == answer){
                sb.append("Poor KCM" + "\n");
            } else {
                sb.append(answer + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, 0));
        dist_cost[start][0] = 0;
        int answer = INF;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int cost = node.getCost();
            int dist = node.getDistance();

            if(now == N) {
//                for (int i = 0; i <= M ; i++) {
//                    answer = Math.min(dist_cost[now][i], answer);
//                }

                answer = Math.min(answer, dist);
                break;
            }


            for (int i = 0; i < graph.get(now).size(); i++) {
                Node nextNode = graph.get(now).get(i);
                int next = nextNode.getIndex();
                int next_cost = nextNode.getCost() + cost;
                int next_dist = nextNode.getDistance() + dist;

                // 제한 금액 초과시 continue
                if(next_cost > M) {
                    continue;
                }

                if(dist_cost[next][next_cost] > next_dist) {
                    dist_cost[next][next_cost] = next_dist;
                    pq.offer(new Node(next, next_cost, next_dist));
                }
            }
        }

        return answer;
    }

    static class Node implements Comparable<Node>{
        private int index;
        private int cost;
        private int distance;

        public Node(int index, int cost, int distance) {
            this.index = index;
            this.cost = cost;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getCost() {
            return cost;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance == o.distance) {
                return this.cost - o.cost;
            } else {
                return this.distance - o.distance;
            }
        }
    }
}
