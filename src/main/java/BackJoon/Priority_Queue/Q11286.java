package BackJoon.Priority_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> arr = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2)
                return o1 > o2 ? 1 : -1;

            return abs1 - abs2;
        });

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (arr.peek() != null) {
                    sb.append(arr.poll() + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else {
                arr.offer(x);
            }
        }
        System.out.print(sb);
    }
}
