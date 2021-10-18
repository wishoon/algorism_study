package v3.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2304_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int max_height = Integer.MIN_VALUE;
        int max_pos = 0;

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new Node(pos, height));

            if(max_height < height) {
                max_height = height;
                max_pos = pos;
            }
        }
        Collections.sort(list);

        int max_index = 0;
        for (int i = 0; i < list.size(); i++) {
            if(max_pos == list.get(i).pos) {
                max_index = i;
                break;
            }
        }

        int answer = 0;
        for (int i = 0; i <= max_index; i++) {
            for (int j = i + 1; j <= max_index; j++) {
                if(list.get(i).height <= list.get(j).height) {
                    answer += (list.get(j).pos - list.get(i).pos) * list.get(i).height;
                    i = j;
                }
            }
        }

        for (int i = n - 1; i >= max_index ; i--) {
            for (int j = i - 1; j >= max_index; j--) {
                if(list.get(i).height <= list.get(j).height) {
                    answer += (list.get(i).pos - list.get(j).pos) * list.get(i).height;
                    i = j;
                }
            }
        }

        System.out.println(answer + max_height);
    }

    static class Node implements Comparable<Node>{
        int pos;
        int height;

        public Node(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }

        @Override
        public int compareTo(Node node) {
            return this.pos - node.pos;
        }
    }
}
