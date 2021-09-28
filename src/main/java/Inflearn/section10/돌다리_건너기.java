package Inflearn.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌다리_건너기 {

    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fibo = new int[n + 2];
        fibo[1] = 1;
        fibo[2] = 1;

        fibo(n + 1);

        System.out.println(fibo[n + 2]);
    }

    public static int fibo(int n) {
        /*
        if(n == 1 || n == 2) {
            return 1;
        }

        return fibo(n - 2) + fibo(n - 1);
         */

        for (int i = 3; i < n + 1; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }

        return fibo(n + 1);
    }
}
