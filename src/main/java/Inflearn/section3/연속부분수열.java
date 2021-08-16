package Inflearn.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속부분수열 {

    static int N = 0, M = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int sum = 0;
        int cnt = 0;

        for (int right = 0; right < N; right++) {
            sum += arr[right];
            if(sum == M) {
                cnt++;
            }
            while(sum >= M) {
                sum -= arr[left++];
                if(sum == M) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
