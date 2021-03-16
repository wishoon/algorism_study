package v2.BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와_링크 {

    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(MIN);
    }
    public static void dfs(int idx, int depth) {
        if(depth == N / 2) {
            decision();
            return;
        }

        for (int i = idx; i < N; i++) {

            if(!visit[i]) {
                visit[i] = true;
                dfs(idx + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void decision() {
        int v1 = Integer.MAX_VALUE;
        int v2 = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(visit[i] == true && visit[j] == true) {
                    v1 += arr[i][j] + arr[j][i];
                } else if(visit[i] == false && visit[j] == false)
                    v2 += arr[i][j] + arr[j][i];
            }
        }
        int val = Math.abs(v1 - v2);

        if(val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        MIN = Math.min(val, MIN);
    }
}
