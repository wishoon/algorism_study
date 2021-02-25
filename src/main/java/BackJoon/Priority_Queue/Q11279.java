package BackJoon.Priority_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> arr = new PriorityQueue<>((o1, o2) -> {
            if (o1 < o2)
                return 1;
            else
                return -1;
        });
//        PriorityQueue<Integer> arr = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 < o2)
//                    return 1;
//                else
//                    return -1;
//            }
//        });

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(arr.peek() != null){
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
