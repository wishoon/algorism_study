package BackJoon.Shortest_Path;

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
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] d = new int[100001];
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // start -> end
            graph.get(a).add(new Node(b, c));

            // end -> start
            graph.get(b).add(new Node(a, c));
        }

        // 반드시 거쳐야 하는 정점
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 만약 거처야 하는 정점이 없다면 다이렉트로 기존처럼 1번만 실행하면 된다.

        int res1 = 0;
        int res2 = 0;
        // 1 -> v1 -> v2 -> N
        res1 += dijjkstra(1, v1);
        res1 += dijjkstra(v1, v2);
        res1 += dijjkstra(v2, N);

        // 1 -> v2 -> v1 -> N
        res2 += dijjkstra(1, v2);
        res2 += dijjkstra(v2, v1);
        res2 += dijjkstra(v1, N);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

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
            int distance = node.getDistance();

            if(d[now] < distance)
                continue;

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }

        return d[end];
    }
    static class Node implements Comparable<Node>{
        private int index;
        private int distance;

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

