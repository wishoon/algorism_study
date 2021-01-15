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
    public static boolean[] visited = new boolean[100002];
    public static int[] arr = new int[100002];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<=100000; i++){
            arr[i] = -1;
        }
        dfs();
    }
    public static void dfs(){

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        arr[N] = 0;

        while (!q.isEmpty()){
            int curX = q.peek();
            visited[curX] = true;
            q.poll();

            for (int i = 0; i < 3; i++) {
                int nextX = 0;

                if(i==0)
                    nextX = curX + 1;
                else if(i==1)
                    nextX = curX - 1;
                else if(i==2)
                    nextX = curX * 2;

                if(nextX < 0 || nextX >= 100000)
                    continue;

                if(!visited[nextX]){
                    q.offer(nextX);
                    visited[nextX] = true;
                    arr[nextX] = arr[curX] + 1;
                }
            }
        }
        System.out.println(arr[M]);
    }
}
