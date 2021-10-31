package v3.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1987 {
    static int r, c;
    static char[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static HashSet<Character> alpha = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        dfs(0, 0, 0);

        System.out.println(max);
    }

    public static void dfs(int cr, int cc, int cnt) {

        char curAlpha = arr[cr][cc];
        if (alpha.contains(curAlpha)) {
            max = Math.max(max, cnt);
            return;
        }

        alpha.add(curAlpha);
        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + cr;
            int nc = dc[i] + cc;

            if(nr < 0 || nr >= r || nc < 0 || nc >= c) {
                continue;
            }
            dfs(nr, nc, cnt + 1);
        }

        alpha.remove(curAlpha);
    }
}
