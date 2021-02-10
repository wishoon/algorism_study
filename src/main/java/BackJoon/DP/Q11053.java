package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11053 {

    static int arr[];
    static Integer dp[];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new Integer[N];

        String input[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < N; i++) {
            lts(i);
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static int lts(int n){
        if(dp[n] == null){
            dp[n] = 1;

            for (int i = n-1; i >= 0; i--) {
                if(arr[i] < arr[n])
                    dp[n] = Math.max(dp[n], lts(i) + 1);
            }
        }
        return dp[n];
    }
}
