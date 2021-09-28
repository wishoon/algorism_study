package v3.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            String[] phone = new String[n];
            for (int j = 0; j < n; j++) {
                phone[j] = br.readLine();
            }
            Arrays.sort(phone);

            if(isTrue(n, phone)) {
                sb.append("YES" + "\n");
            } else {
                sb.append("NO" + "\n");
            }
        }
        System.out.print(sb);
    }

    public static boolean isTrue(int n, String[] phone) {

        for (int i = 0; i < n - 1; i++) {
            if(phone[i + 1].startsWith(phone[i])) {
                return false;
            }
        }
        return true;
    }
}
