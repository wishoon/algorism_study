package v3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] array = new int[11];

        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 4; j <= n; j++) {
                array[j] = array[j - 1] + array[j - 2] + array[j - 3];
            }
            sb.append(array[n]).append("\n");
        }

        System.out.print(sb);
    }
}
