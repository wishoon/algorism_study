package Inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬나라_아일랜드_DFS {

    static int n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if(arr[y][x] == 1) {
                    dfs(y, x);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int y, int x) {

        for (int i = 0; i < 8; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if(nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
                continue;
            }

            if(arr[nextY][nextX] == 1) {
                arr[nextY][nextX] = 0;
                dfs(nextY, nextX);
            }
        }
    }
}
