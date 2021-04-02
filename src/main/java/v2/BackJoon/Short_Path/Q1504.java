package v2.BackJoon.Short_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1504 {

    static int N;
    static int E;
    static int v1;
    static int v2;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int d[];
    static int INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        INF = N * E;

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        d = new int[N + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));

            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int total1 = 0;

        total1 += dijjkstra(1, v1);
        total1 += dijjkstra(v1, v2);
        total1 += dijjkstra(v2, N);

        int total2 = 0;

        total2 += dijjkstra(1, v2);
        total2 += dijjkstra(v2, v1);
        total2 += dijjkstra(v1, N);

        int ans = (total1 >= INF && total2 >= INF) ? -1 : Math.min(total1, total2);

        System.out.println(ans);
    }

    public static int dijjkstra(int start, int end) {

        Arrays.fill(d, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int now = node.getIndex();
            int dist = node.getDistance();

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

        return d[end];
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

        @Override
        public int compareTo(Node o) {
            if(this.distance < o.distance)
                return -1;

            return 1;
        }
    }
}
