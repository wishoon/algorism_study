package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {

    static int zero = 0;
    static int one = 0;
    static Integer[][] fibo = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        // i는 n j는 호출 횟수
        fibo[0][0]= 1;
        fibo[0][1]= 0;
        fibo[1][0]= 0;
        fibo[1][1]= 1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibo(N);
            sb.append(fibo[N][0] + " " + fibo[N][1]).append("\n");
        }
        System.out.print(sb);
    }
    public static Integer[] fibo(int n){
        if(fibo[n][0] == null || fibo[n][1] == null) {
            fibo[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
            fibo[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
        }
        return fibo[n];
    }
}
