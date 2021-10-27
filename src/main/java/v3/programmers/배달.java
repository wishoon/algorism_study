package v3.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 배달 {
    public static void main(String[] args) {

        int n = 5;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int k = 3;

        solution(n, road, k);
    }

    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    public static int solution(int n, int[][] road, int k) {

        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < road.length; i++) {
            int n1 = road[i][0];
            int n2 = road[i][1];
            int cost = road[i][2];

            graph.get(n1).add(new Node(n2, cost));
            graph.get(n2).add(new Node(n1, cost));
        }

        dijkstra(1);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= k) {
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur_index = node.index;
            int cur_cost = node.cost;

            if (dist[node.index] < node.cost) {
                continue;
            }

            for (int i = 0; i < graph.get(cur_index).size(); i++) {
                int next_index = graph.get(cur_index).get(i).index;
                int next_cost = graph.get(cur_index).get(i).cost;

                if (dist[next_index] > cur_cost + next_cost) {
                    dist[next_index] = cur_cost + next_cost;
                    pq.offer(new Node(next_index, cur_cost + next_cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }
}
