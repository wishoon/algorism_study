package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 멘토링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[M][N];

        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(solution(N, M, arr));
    }

    private static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj = 0;
                    for (int l = 0; l < n; l++) {
                        if(arr[k][l] == i) {
                            pi = l;
                        }
                        if(arr[k][l] == j) {
                            pj = l;
                        }
                    }
                    if(pi < pj) {
                        cnt++;
                    }
                }
                if(cnt == m) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
