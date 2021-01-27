package BackJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1018_1 {

    static int N;
    static int M;
    static boolean[][] board;
    public static int min = 64;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == 'W')
                    board[i][j] = true;
                else
                    board[i][j] = false;
            }
        }
        // 경우의 수 2 × (N - 7) × (M - 7)

        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    public static void find(int x, int y){
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = board[x][y]; // 첫번째가 무엇인지

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if(board[i][j] != TF)
                    count++;

                TF = (!TF);
            }
            TF = !TF;
        }
        count = Math.min(count, 64 - count);

        min = Math.min(min, count);
    }
}
