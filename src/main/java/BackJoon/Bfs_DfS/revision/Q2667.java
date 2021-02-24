package BackJoon.Bfs_DfS.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q2667 {

    static int[][] arr;
    static int N;
    static int count = 0;
    static int count2 = 0;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<Integer> result = new ArrayList<>();

        arr = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visit[i][j]) {
                    count++;
                    dfs(i, j);
                    result.add(count2);
                    count2 = 0;
                }
            }
        }
        Collections.sort(result);
        System.out.println(count);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static void dfs(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int new_x = i + dx[k];
            int new_y = j + dy[k];

            if(new_x >= 0 && new_x < N && new_y >= 0 && new_y < N) {
                if(arr[new_x][new_y] == 1 && !visit[new_x][new_y]){
                    visit[new_x][new_y] = true;
                    count2++;
                    dfs(new_x, new_y);
                }
            }
        }
        if (count2 == 0) {
            count2++;
        }
    }
}
