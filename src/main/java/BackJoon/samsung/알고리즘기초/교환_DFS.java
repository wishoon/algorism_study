package BackJoon.samsung.알고리즘기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 교환_DFS {
    static String N;
    static int K, M;
    static int[][] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        M = N.length();
        // DP 선언
        dp = new int[K + 1][1000001];		// [변경횟수] [최대숫자] 2차원 visit 배열

        // N : 입력되는 숫자
        // M : N의 자리수 -> 입력되는 것은 아님
        // K : 주어지는 연산의 수행 횟수

        System.out.println(dfs(N,0));
    }

    private static int dfs(String str, int idx) {

        int num = Integer.parseInt(str);
        if(K == idx) {
            return num;
        }

        int ret = dp[idx][num];
        if(ret != 0) {
            return ret;
        }

        ret = -1;
        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {

                if(i == 0 && str.charAt(j) == '0') {
                    continue;
                }
                String swap_str = swap(str, i, j);
                int temp_num = dfs(swap_str, idx + 1);
                ret = Math.max(ret, temp_num);
            }
        }

        System.out.println(idx + " " +  num + " " + ret);
        dp[idx][num] = ret;

        return ret;
    }

    static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);
    }
}
