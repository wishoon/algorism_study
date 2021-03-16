package v2.BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {

    static int N;
    static int[] arr;
    static int[] calculate = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            calculate[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int num, int depth) {

        if(depth == N){
            // 최대, 최소 비교
            max = Math.max(max, num);
            min = Math.min(min, num);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if(calculate[i] > 0) {
                calculate[i]--;
                switch (i){
                    case 0: dfs(num + arr[depth], depth + 1); break;
                    case 1: dfs(num - arr[depth], depth + 1); break;
                    case 2: dfs(num * arr[depth], depth + 1); break;
                    case 3: dfs(num / arr[depth], depth + 1); break;
                }
                calculate[i]++;
            }
        }
    }
}
