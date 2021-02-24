package BackJoon.Bfs_DfS.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1697 {
    static int N;
    static int K;
    static int[] arr = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        bfs();
        System.out.println(arr[K]);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        arr[N] = 0;

        while (!queue.isEmpty()){
            int n = queue.poll();

            if(arr[K] != 0)
                break;

            if (n - 1 >= 0 && arr[n - 1] == 0) {
                arr[n - 1] = arr[n] + 1;
                queue.offer(n - 1);
            }
            if(n + 1 < 100001 && arr[n + 1] == 0) {
                arr[n + 1] = arr[n] + 1;
                queue.offer(n + 1);
            }
            if(n * 2 < 100001 && arr[n * 2] == 0){
                arr[n * 2] = arr[n] + 1;
                queue.offer(n * 2);
            }
        }
    }
}
