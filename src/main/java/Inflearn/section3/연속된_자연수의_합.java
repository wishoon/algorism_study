package Inflearn.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된_자연수의_합 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int M = N / 2 + 1;
        int cnt = 0;
        int lt = 1;
        int sum = 0;
        for (int rt = 1; rt <= M; rt++) {
            sum += rt;
            if(sum == N) {
                cnt++;
            }
            while(sum >= N) {
                sum -= lt++;
                if(sum == N) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
