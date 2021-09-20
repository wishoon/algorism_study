package Inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 수열_추측하기 {

    static int n = 0;
    static int num = 0;
    static int[][] dy = new int[35][35];
    static int[] arr;
    static int[] visit;
    static int[] answer;
    static int[] c;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new int[n];
        answer = new int[n];
        c = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
            c[i] = combi(n - 1, i);
        }

        dfs(0, 0);
    }

    public static void dfs(int sum, int depth) {
        if (flag == true) {
            return;
        }

        if(depth == arr.length) {
            if(sum == num) {
                flag = true;
                for (int i : answer) {
                    System.out.print(i + " ");
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if(visit[i] == 0) {
                    visit[i] = 1;
                    answer[depth] = arr[i];
                    dfs(sum + (answer[depth] * c[depth]), depth + 1);
                    visit[i] = 0;
                }
            }
        }
    }

    public static int combi(int n, int r) {
        if(dy[n][r] > 0)
            return dy[n][r];

        if(n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }
}
