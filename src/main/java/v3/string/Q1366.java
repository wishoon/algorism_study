package v3.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1366 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if(check()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean check() throws IOException {
        int[] alpha = new int[26];
        int prev = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        for (int j = 0; j < str.length(); j++) {
            int now = str.charAt(j);
            if(prev != now) {
                if(alpha[now - 'a'] == 1) {
                    return false;
                } else {
                    prev = now;
                    alpha[now - 'a'] = 1;
                }
            }
        }
        return true;
    }
}
