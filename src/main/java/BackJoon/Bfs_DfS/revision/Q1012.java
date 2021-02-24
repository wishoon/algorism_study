package BackJoon.Bfs_DfS.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1012 {

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visit;
    static int T;   // 테스트 케이스
    static int M;   // 가로길이
    static int N;   // 세로길이
    static int K;   // 배추의 위치 갯수
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        String input[];

        for (int i = 0; i < T; i++) {
            input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            arr = new int[N][M];
            visit = new boolean[N][M];
            count = 0;
            for (int j = 0; j < K; j++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                arr[y][x] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(!visit[j][k] && arr[j][k] == 1) {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            st.append(count + "\n");
        }

        System.out.print(st);
    }

    public static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int curx = x + dx[i];
            int cury = y + dy[i];

            if(curx < 0 || cury < 0 || curx >= M || cury >= N)
                continue;

            if(!visit[cury][curx] && arr[cury][curx] == 1) {
                visit[cury][curx] = true;
                dfs(cury, curx);
            }
        }
    }
}
