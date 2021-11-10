package v3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Date[] arr = new Date[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int during = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            arr[i] = new Date(during, pay);
        }

        int[] dp = new int[n + 2];

        for (int i = n; i > 0; i--) {
            int nextDay = i + arr[i].during;

            // 데드라인을 넘기지 않는 경우
            if (nextDay <= n + 1) {
                dp[i] = Math.max(arr[i].pay + dp[nextDay], dp[i + 1]);
            }
            // 데드라인을 넘기는 경우
            else {
                dp[i] = dp[i + 1];
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

    static class Date {
        int during;
        int pay;

        public Date(int during, int pay) {
            this.during = during;
            this.pay = pay;
        }
    }
}
