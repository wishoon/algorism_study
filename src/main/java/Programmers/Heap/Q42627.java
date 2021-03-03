package Programmers.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q42627 {
    public static void main(String[] args) {

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        solution(jobs);
    }

    public static void solution(int[][] jobs) {

        int answer = 0;
        int end = 0;    // 수행되고난 직후의 시간
        int count = 0;
        int jobindex = 0;

        // 요청 시간 오름 차순
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (count < jobs.length) {

            while (jobindex < jobs.length && jobs[jobindex][0] <= end) {
                pq.add(jobs[jobindex++]);
            }

            if(pq.isEmpty()) {
                end = jobs[jobindex][0];
            }

            // 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
            else {
                int[] temp= pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }

        System.out.println((int) Math.floor(answer / jobs.length));
    }
}
