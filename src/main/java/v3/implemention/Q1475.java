package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str_n = String.valueOf(n);

        int[] visit = new int[10];
        int cnt = 0;
        int cnt69 = 0;
        for (int i = 0; i < str_n.length(); i++) {
            int num = str_n.charAt(i) - '0';
            if(num == 6 || num == 9) {
                cnt69++;
            } else {
                visit[num]++;
                cnt = Math.max(cnt, visit[num]);
            }
        }

        int answer = 0;
        if (cnt69 % 2 == 0) {
            answer += cnt69 / 2;
        } else {
            answer += cnt69 / 2 + 1;
        }

        answer = Math.max(answer, cnt);

        System.out.println(answer);
    }
}
