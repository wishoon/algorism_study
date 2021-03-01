package BackJoon.Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9370 {

    static int T;
    static int n, m, t, s, g, h; // 테스트, 교차로, 도로, 목적지, 예술가 출발지
    static int a, b, d;
    static List<Integer> candidate; // 목적지 후보
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {

            dist = new int[100001];
            Arrays.fill(dist, INF);

            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int x = 0; x <= n; x++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < m ; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                if ((a == g && b == h) || (a == h && b == g)) {
                    graph.get(a).add(new Node(b, d * 2 - 1));
                    graph.get(b).add(new Node(a, d * 2 - 1));
                } else {
                    graph.get(a).add(new Node(b, d * 2));
                    graph.get(b).add(new Node(a, d * 2));
                }
            }

            candidate = new ArrayList<>();
            for (int k = 0; k < t; k++) {
                candidate.add(Integer.parseInt(br.readLine()));
            }

            dijkstra(s);

            Collections.sort(candidate);

            for (int num : candidate) {
                if (dist[num] % 2 == 1)
                   sb.append(num + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.index;
            int distance = node.distance;

            if(dist[now] < distance)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dist[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < dist[graph.get(now).get(i).getIndex()]){
                    dist[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
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
