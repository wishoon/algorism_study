package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667 {

    public static int[][] arr;
    public static boolean[][] visited;
    public static List<Integer> list;

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void bfs(int y, int x){
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        int count = 0;

        while (!queue.isEmpty()){

            int curY = queue.peek()[0];
            int curX = queue.peek()[1];

            queue.poll();

            if(curY < 0 || curX < 0 || curY >= N || curX >= N){
                continue;
            }
            if(arr[curY][curX] == 0) continue;
            if(visited[curY][curX]) continue;

            count += 1;
            visited[curY][curX] = true;

            queue.offer(new int[] {curY+1, curX});
            queue.offer(new int[] {curY-1, curX});
            queue.offer(new int[] {curY, curX+1});
            queue.offer(new int[] {curY, curX-1});
        }
        list.add(count);
    }
}
