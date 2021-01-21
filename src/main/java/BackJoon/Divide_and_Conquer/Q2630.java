package BackJoon.Divide_and_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630 {

    static int[][] arr;
    static int zero = 0;
    static int one = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0, 0 ,N);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void div(int x, int y, int n){

        // 먼저 배열에 1로 가득있는지 검사
        int count = 0;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[i][j] == 1)
                    count++;
            }
        }
        if(count == 0)
            zero++;
        else if(count == n*n)
            one++;
        else {
            div(x, y, n/2);
            div(x, y + n/2, n/2);
            div(x + n/2, y, n/2);
            div(x + n/2, y + n/2, n/2);
        }

    }
}
