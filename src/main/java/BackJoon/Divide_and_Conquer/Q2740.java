package BackJoon.Divide_and_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2740 {

    static int[][] arr1;
    static int[][] arr2;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1[] = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);
        arr1 = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr1[i][j] = Integer.parseInt(str[j]);
            }
        }

        String input2[] = br.readLine().split(" ");

        M = Integer.parseInt(input2[0]);
        int K = Integer.parseInt(input2[1]);

        arr2 = new int[M][K];

        for (int i = 0; i < M; i++) {
            String str[] = br.readLine().split(" ");
            for (int j = 0; j < K; j++) {
                arr2[i][j] = Integer.parseInt(str[j]);
            }
        }

        result = new int[N][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
