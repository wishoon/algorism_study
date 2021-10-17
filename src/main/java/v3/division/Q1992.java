package v3.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1992 {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        division_square(n, 0, 0);
        System.out.println(sb);
    }

    public static void division_square(int size, int r, int c) {

        if (search_square(size, r, c)){
            int flag = arr[r][c];
            sb.append(flag);

            return;
        }

        sb.append("(");

        division_square(size / 2, r, c);
        division_square(size / 2, r, c + size / 2);
        division_square(size / 2, r + size / 2, c);
        division_square(size / 2, r + size / 2, c + size / 2);

        sb.append(")");
    }

    public static boolean search_square(int size, int r, int c) {
        int flag = arr[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                 if (flag != arr[i][j]) {
                     return false;
                 }
            }
        }

        return true;
    }
}
