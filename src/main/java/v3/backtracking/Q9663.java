package v3.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {

    static int n;
    static int cnt = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        dfs(0);

        System.out.println(cnt);
    }

    public static void dfs(int row) {

        if (row == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // 지금 row 행의 i 번째를..
            arr[row] = i;
            if(possibility(row)) {
                dfs(row + 1);
            }
        }
    }

    public static boolean possibility(int col) {

        for (int i = 0; i < col; i++) {

            if(arr[col] == arr[i]) {
                return false;
            }
            else if(Math.abs(arr[col] - arr[i]) == Math.abs(col - i)) {
                return false;
            }
        }
        return true;
    }
}
