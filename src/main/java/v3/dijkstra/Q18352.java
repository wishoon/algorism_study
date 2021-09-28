package v3.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M, K, X;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, 1));
        }

        dfs(X, graph, cost);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < cost.length; i++) {
            if (cost[i] == K) {
                sb.append(i + "\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    public static void dfs(int start, List<List<Node>> graph, int[] cost) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        cost[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < graph.get(node.index).size(); i++) {
                int next_index = graph.get(node.index).get(i).index;
                int next_cost = graph.get(node.index).get(i).cost;

                if(cost[next_index] > node.cost + next_cost) {
                    queue.offer(new Node(next_index, node.cost + next_cost));
                    cost[next_index] = node.cost + next_cost;
                }
            }
        }

    }

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
