package BackJoon.Divide_and_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1780 {
    static int Zero = 0;
    static int One = 0;
    static int Minus = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0, 0, N);
        System.out.println(Minus);
        System.out.println(Zero);
        System.out.println(One);
    }

    public static void div(int x, int y, int n){
        int zero = 0;
        int one = 0;
        int minus = 0;

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[i][j] == 0){
                    zero++;
                } else if(arr[i][j] == 1){
                    one++;
                } else{
                    minus++;
                }
            }
        }

        if(zero == n*n)
            Zero++;
        else if(one == n*n)
            One++;
        else if(minus == n*n)
            Minus++;
        else {
            div(x, y, n/3);;
            div(x, y + n/3, n/3);
            div(x, y + 2 * n / 3, n/3);

            div(x + n/3, y, n/3);
            div(x + n/3, y + n/3, n/3);
            div(x + n/3, y + 2 * n/3, n/3);

            div(x + 2 * n/3, y, n/3);
            div(x + 2 * n/3, y + n / 3, n/3);
            div(x + 2 * n/3, y + 2 * n/3, n/3);

        }
    }
}
