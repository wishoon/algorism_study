package BackJoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {
    static Integer[][] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        fibo = new Integer[41][2];
        // N이 0일 때 0 또는 1 호출 횟
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibo(N);
            sb.append(fibo[N][0] + " " + fibo[N][1] + "\n");
        }
        System.out.println(sb);
    }

    private static Integer[] fibo(int n) {

        if(fibo[n][0] == null || fibo[n][1] == null) {
            fibo[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            fibo[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }

        return fibo[n];
    }
}
