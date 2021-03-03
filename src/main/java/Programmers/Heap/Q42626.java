package Programmers.Heap;

import java.util.PriorityQueue;

public class Q42626 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;


        solution(scoville, K);
    }
    public static void solution(int[] scoville, int K){
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int score : scoville) {
            pq.offer(score);
        }

        while (pq.peek() < K){
            if(pq.size() < 2)
                System.out.println(-1);

            int first = pq.poll();
            int second = pq.poll();

            int mixScoville = first + second * 2;

            answer++;
            pq.offer(mixScoville);
        }

        System.out.println(answer);
    }
}
