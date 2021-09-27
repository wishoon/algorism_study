package v3.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M, X;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<Node>> inverse_graph = new ArrayList<>();
        List<List<Node>> reverse_graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            inverse_graph.add(new ArrayList<>());
            reverse_graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            inverse_graph.get(a).add(new Node(b, c));
            reverse_graph.get(b).add(new Node(a, c));
        }

        int[] reverse = new int[N + 1];
        Arrays.fill(reverse, Integer.MAX_VALUE);

        int[] inverse = new int[N + 1];
        Arrays.fill(inverse, Integer.MAX_VALUE);

        dijkstra(X, reverse, reverse_graph);
        dijkstra(X, inverse, inverse_graph);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, inverse[i] + reverse[i]);
        }

        System.out.println(max);
    }

    public static void dijkstra(int start, int[] dist, List<List<Node>> graph) {
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
