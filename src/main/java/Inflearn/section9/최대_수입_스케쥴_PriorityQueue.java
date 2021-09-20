package Inflearn.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최대_수입_스케쥴_PriorityQueue {

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            list.add(new Node(day, pay));

            if(day > max) {
                max = day;
            }
        }
        solution(list);
    }

    public static void solution(List<Node> list) {
        int answer = 0;

        // 큰 값을 우선순위로 하는
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 날짜에 의한 정렬
        Collections.sort(list);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < list.size(); j++) {
                if(list.get(j).day == i) {
                    pq.offer(list.get(j).pay);
                } else {
                    break;
                }
            }
            // isEmpty()를 반드시 확인해야 한다.
            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }

    static class Node implements Comparable<Node>{
        int day;
        int pay;

        public Node(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }

        @Override
        public int compareTo(Node e) {
            return e.day - this.day;
        }
    }
}
