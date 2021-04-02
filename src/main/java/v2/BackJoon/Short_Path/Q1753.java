package v2.BackJoon.Short_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753 {

    static int V;
    static int E;
    static int K;
    static int INF;
    static ArrayList<ArrayList<Node>> graph;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        // 간선비용이 N보다 작고 정점이 최대 M개 이므로 N*M 값이 INF
        INF = V * E;
        graph = new ArrayList<>();
        d = new int[V + 1];

        // INF로 초기화
        Arrays.fill(d, INF);

        for (int i = 0; i <= E; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijjkstra(K);

        for (int i = 1; i <= V; i++) {
            if(d[i] == INF){
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }
    }

    public static void dijjkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int now = node.getIndex();
            int dist = node.getDistance();

            // 오른쪽 노드가 현재 노드보다 크다면 x
            if(d[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Node o) {
            if(this.distance <  o.distance)
                return -1;
            return 1;
        }
    }
}
