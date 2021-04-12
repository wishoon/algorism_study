package v2.BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 회의의 수
        int n = 0;
        // 시작시간, 종료시간
        ArrayList<Node> time = new ArrayList<>();
        
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        Collections.sort(time, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.end == o2.end) {
                    return o1.start - o2.start;
                }

                return o1.end - o2.end;
            }
        });

        // 찾고자 하는 것 회의가 겹치치 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수. 끝남과 동시에 다른 회의 시작 가능
        int end = 0;
        int count = 0;

        for (int i = 0; i < time.size(); i++) {
            Node node = time.get(i);
            if(end <= node.start) {
                end = node.end;
                count++;
            }
        }
        System.out.println(count);
    }

    static class Node {
        private int start = 0;
        private int end = 0;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
