package Inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_구하기 {
    static int n = 0, m = 0;
    static int[] combi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        combi = new int[m];

        dfs(0, 1);
    }

    public static void dfs(int depth, int start) {
        if(depth == m) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                combi[depth] = i;
                dfs(depth + 1, i + 1);
            }
        }
    }
}
