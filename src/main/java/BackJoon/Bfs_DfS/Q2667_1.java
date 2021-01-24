package BackJoon.Bfs_DfS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q2667_1 {

    public static int N ;
    public static int[][] arr;
    public static boolean[][] visited;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i][0] = str.charAt(0) - '0';
            arr[i][1] = str.charAt(1) - '0';
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visited[i][j])
                    bfs(i, j);
            }
        }
    }

    public static void bfs(int y, int x){

//        Queue<Node> q = new LinkedList<>();
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {y, x});

        int count = 0;
        while(!q.isEmpty()){

            int curX = q.peek()[1];
            int curY = q.peek()[0];

            q.poll();

            if(curX < 0 || curY < 0 || curX >= N || curY >= N){
                continue;
            }
            if(arr[curY][curX] != 1 || visited[curY][curX]){
                continue;
            }

            count++;
            visited[curY][curX] = true;

            q.offer(new int[] {curY - 1, curX});
            q.offer(new int[] {curY + 1, curX});
            q.offer(new int[] {curY, curX - 1});
            q.offer(new int[] {curY, curX + 1});
        }
        list.add(count);
    }
}

//class Node {
//    private int x;
//    private int y;
//
//    public Node(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//}
