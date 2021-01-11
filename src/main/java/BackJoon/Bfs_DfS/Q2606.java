package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2606 {

    public static boolean[] visited;
    public static int[][] graph;
    public static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터의 갯수
        int N = Integer.parseInt(br.readLine());
        // 직접연결되어 있는 갯수
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[100 + 1];
        graph = new int[N+1][N+1];

        String input;
        int one, two;
        for (int i = 0; i < M; i++) {
            input = br.readLine();
            one = Integer.parseInt(input.split(" ")[0]);
            two = Integer.parseInt(input.split(" ")[1]);
            graph[one][two] = graph[two][one] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()){
            // 큐에서 하나 뽑기
            int x = q.poll();

            for (int i = 1 ; i <= N; i++){
                if(graph[i][x] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
