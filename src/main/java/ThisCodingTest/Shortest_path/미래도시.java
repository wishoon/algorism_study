package ThisCodingTest.Shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미래도시 {

    static int N = 5;
    static int M = 7;
    static int X = 4;
    static int K = 5;
    static ArrayList<ArrayList<Node>> graph;
    static int d[] = new int[100 + 1];
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, 1));

            graph.get(b).add(new Node(a, 1));
        }

        int sum = 0;
        sum += dijkstra(1, K);
        sum += dijkstra(K, X);

        System.out.println(sum);
    }
    public static int dijkstra(int start, int end) {
        Arrays.fill(d, INF);

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        d[start] = 0;

        while (!q.isEmpty()){
            Node node = q.poll();

            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now] < dist)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + 1;

                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    q.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }

        return d[end];
    }

    static class Node {
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
    }
}
