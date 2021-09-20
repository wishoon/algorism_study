package Inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합수 {

    static int[][] dy = new int[35][35];
    public static void main(String[] args) throws IOException {

    }

    public static int dfs(int n, int r) {

        if(dy[n][r] != 0) {
            return dy[n][r];
        }

        if(n == r || r == 0) {
            return 1;
        } else {
            return dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }
}
