package v2.BackJoon.Short_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class  Q9370 {
    static int n, m ,t;
    static int s, g, h;
    static ArrayList<ArrayList<Node>> graph;
    // 목적지 후보들
    static ArrayList<Integer> candidate;
    // 최단거리 배열
    static int[] d;
    static int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            ArrayList<Integer> answers = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            d = new int[n + 1];

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Node(b, c));
                graph.get(b).add(new Node(a, c));
            }

            candidate = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                candidate.add(Integer.parseInt(br.readLine()));
            }

            for (int j = 0; j < t; j++) {
                int res1 = 0, res2 = 0, res3 = 0;

                res1 += dijkstra(s, g);
                res1 += dijkstra(g, h);
                res1 += dijkstra(h, candidate.get(j));

                res2 += dijkstra(s, h);
                res2 += dijkstra(h, g);
                res2 += dijkstra(g, candidate.get(j));

                res3 += dijkstra(s, candidate.get(j));

                if(Math.min(res1, res2) == res3) {
                    answers.add(candidate.get(j));
                }
            }
            Collections.sort(answers);

            for (int j = 0; j < answers.size(); j++) {
                sb.append(answers.get(j) + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    public static int dijkstra(int start, int end) {

        d = new int[n + 1];
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
