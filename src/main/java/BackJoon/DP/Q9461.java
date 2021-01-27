package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461 {
    static Long[] arr = new Long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(fibo(N)).append("\n");
        }
        System.out.print(sb);
    }

    public static Long fibo(int n) {
        if(arr[n] == null){
            return arr[n] = fibo(n-2) + fibo(n-3);
        }
        return arr[n];
    }
}
