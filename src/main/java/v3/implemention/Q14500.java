package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int[][] unusual_dr = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    static int[][] unusual_dc = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
    static int[][] arr;
    static int N, M;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                figure_dfs(visit, i, j, arr[i][j], 1);

                visit[i][j] = false;
                // 예외적인 모양 탐색
                figure_unusual(i , j);
            }
        }
        System.out.println(max);
    }

    private static void figure_unusual(int cur_r, int cur_c) {

        for (int i = 0; i < 4; i++) {
            boolean flag = true;
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int next_r = cur_r + unusual_dr[i][j];
                int next_c = cur_c + unusual_dc[i][j];
                if (next_r < 0 || next_r >= N || next_c < 0 || next_c >= M) {
                    flag = false;
                    break;
                }
                sum += arr[next_r][next_c];
            }

            if (flag) {
                max = Math.max(max, sum);
            }
        }
    }

    private static void figure_dfs(boolean[][] visit, int cur_r, int cur_c, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int next_r = cur_r + dr[i];
            int next_c = cur_c + dc[i];

            if (next_r < 0 || next_r >= N || next_c < 0 || next_c >= M) {
                continue;
            }

            if (!visit[next_r][next_c]) {
                visit[next_r][next_c] = true;
                figure_dfs(visit, next_r, next_c, sum + arr[next_r][next_c], depth + 1);
                visit[next_r][next_c] = false;
            }
        }
    }


    /*
    자세히 살펴보면 DFS를 통해서 주어진 모양 중 'ㅜ'를 제외한 모든 모양 탐색이 가능함.
    즉, 순서를 따지면
    1. DFS Depth가 4가 나올때까지 탐색하고 이를 카운트
    2. 'ㅜ' 모양에 대한 4가지 방향 회전 탐색을 하여 일치 할 경우 카운트
    3. 정답
     */
}
