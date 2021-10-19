package v3.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Node[] arr = new Node[n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int one = Integer.parseInt(st.nextToken());
                int two = Integer.parseInt(st.nextToken());
                arr[j] = new Node(one, two);
            }
            Arrays.sort(arr);
            int cnt = 1;
            int min = arr[0].two;

            for (int j = 1; j < n; j++) {
                if(min > arr[j].two) {
                    cnt++;
                    min = arr[j].two;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static class Node implements Comparable<Node>{
        int one;
        int two;

        public Node(int one, int two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public int compareTo(Node o) {
            return this.one - o.one;
        }
    }
}
