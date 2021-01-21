package BackJoon.Divide_and_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {

    static int[][] arr;
    static int white = 0;
    static int black = 0;
    static StringBuilder sb = new StringBuilder();
    static int total_count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        div(0, 0, N);
        if(total_count == 1){
            System.out.println(sb);
        }
        else
            System.out.println(sb);
    }

    public static void div(int x, int y, int n){
        int count = 0;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[i][j] == 1)
                    count++;
            }
        }
        if(count == 0){
            sb.append("0");
        } else if(count == n*n)
            sb.append("1");
        else {
            sb.append("(");
            div(x, y, n/2);
            div(x, y + n/2, n/2);
            div(x + n/2, y, n/2);
            div(x + n/2, y + n/2, n/2);
            sb.append(")");
        }
        total_count++;
    }
}
