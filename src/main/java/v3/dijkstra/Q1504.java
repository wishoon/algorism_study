package v3.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1504 {

    static int INF = 200000000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, E;

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dist = new int[N + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, d));
            graph.get(e).add(new Node(s, d));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0, ans2 = 0;

        ans1 += dijkstra(1, v1, dist, graph);
        ans1 += dijkstra(v1, v2, dist, graph);
        ans1 += dijkstra(v2, N, dist, graph);


        ans2 += dijkstra(1, v2, dist, graph);
        ans2 += dijkstra(v2, v1, dist, graph);
        ans2 += dijkstra(v1, N, dist, graph);

        if(ans1 < INF || ans2 < INF) {
            System.out.println(Math.min(ans1, ans2));
        } else {
            System.out.println(-1);
        }
    }

    public static int dijkstra(int start, int end, int[] dist, List<List<Node>> graph) {
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int now_index = node.index;
            int now_dist = node.dist;

            if(dist[now_index] < now_dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now_index).size(); i++) {
                int next_index = graph.get(now_index).get(i).index;
                int next_dist = graph.get(now_index).get(i).dist;

                if(dist[next_index] > now_dist + next_dist) {
                    dist[next_index] = now_dist + next_dist;
                    pq.offer(new Node(next_index, now_dist + next_dist));
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node>{
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {
            return this.dist - node.dist;
        }
    }
}
