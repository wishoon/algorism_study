package v3.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987_2 {
    static int r, c;
    static int[][] arr;
    static boolean[] visit = new boolean[26];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 0);

        System.out.println(max);
    }

    public static void dfs(int cr, int cc, int cnt) {

        if (visit[arr[cr][cc]]) {
            max = Math.max(max, cnt);
            return;
        }

        visit[arr[cr][cc]] = true;
        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + cr;
            int nc = dc[i] + cc;

            if(nr < 0 || nr >= r || nc < 0 || nc >= c) {
                continue;
            }
            dfs(nr, nc, cnt + 1);
        }
        visit[arr[cr][cc]] = false;
    }
}
