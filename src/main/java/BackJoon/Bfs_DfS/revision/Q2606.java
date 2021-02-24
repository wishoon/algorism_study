package BackJoon.Bfs_DfS.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2606 {

    static int N;   // 컴퓨터의 수
    static int M;   // 컴퓨터의 쌍의 수
    static int[][] arr; // 컴퓨터간의 연결 유무
    static boolean[] visit; // 방문 여부 확인
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            String input[] = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arr[x][y] = arr[y][x] = 1;
        }
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int n) {

        visit[n] = true;
        for (int i = 1; i <= N; i++) {
            if(arr[n][i] == 1 && !visit[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
