package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9184 {

    static int a;
    static int b;
    static int c;
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int result = 0;
        while (true){
            String str[] = br.readLine().split(" ");
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            c = Integer.parseInt(str[2]);

            if(a==-1 && b==-1 && c==-1)
                break;

            sb.append("w(" + a + "," + " " + b + "," + " " + c + ") = " + dp(a, b, c)).append("\n");
        }
        System.out.print(sb);
    }

    public static int dp(int a, int b, int c){
        // 이때 혹시 범위를 벗어날 가능성이 있기 때문에 체크 함수를 통해서 확인이 필요하다.
        if(isRange(a, b, c) && dp[a][b][c] != 0){
            return dp[a][b][c];
        }
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = dp(20, 20, 20);
        }

        if(a < b && b < c) {
            return dp[a][b][c] = dp(a, b, c-1) + dp(a, b-1, c-1) - dp(a, b-1, c);
        }
        return dp[a][b][c] = dp(a-1, b, c) + dp(a-1, b-1, c) + dp(a-1, b, c-1) - dp(a-1, b-1, c-1);
    }

    public static boolean isRange(int a, int b, int c){
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
