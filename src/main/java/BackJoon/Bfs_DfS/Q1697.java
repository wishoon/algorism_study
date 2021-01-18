package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {

    public static int N;
    public static int M;
//    public static boolean[] visited = new boolean[100001];
    public static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N == M){
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(arr[M]);
    }
    public static void bfs(){

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        arr[N] = 0;

        while (!q.isEmpty()) {
            int n = q.poll();

            if (arr[M] != 0)
                break;
            if (n + 1 < 100001 && arr[n + 1] == 0) {
                arr[n + 1] = arr[n] + 1;
                q.offer(n + 1);
            }

            if (n - 1 >= 0 && arr[n - 1] == 0) {
                arr[n - 1] = arr[n] + 1;
                q.offer(n - 1);
            }

            if (n * 2 < 100001 && arr[n * 2] == 0) {
                arr[n * 2] = arr[n] + 1;
                q.offer(n * 2);
            }
        }
    }
}

//while (!q.isEmpty()){
//        int curX = q.peek();
//        visited[curX] = true;
//        q.poll();
//
//        for (int i = 0; i < 3; i++) {
//        int nextX = 0;
//
//        if(i==0)
//        nextX = curX + 1;
//        else if(i==1)
//        nextX = curX - 1;
//        else if(i==2)
//        nextX = curX * 2;
//
//        if(nextX < 0 || nextX >= 100000)
//        continue;
//
//        if(!visited[nextX]){
//        q.offer(nextX);
//        visited[nextX] = true;
//        arr[nextX] = arr[curX] + 1;
//        }
//        }
//        }