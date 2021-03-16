package v2.BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠 {

    public static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }
    public static void dfs(int row, int col) {
        if(col == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if(checking(i, row, col)) {
                    arr[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        dfs(row, col + 1);
    }

    public static boolean checking(int num, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if(arr[i][col] == num || arr[row][i] == num) {
                return false;
            }
        }

        int t_row = (row / 3) * 3;
        int t_col = (col / 3) * 3;

        for (int i = t_col; i < 3; i++) {
            for (int j = t_row; j < 3; j++) {
                if(arr[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}
