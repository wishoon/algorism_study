package Inflearn.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_매출 {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, answer = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        answer = sum;
        for (int i = K; i < N; i++) {
            sum += (arr[i] - arr[i - K]);
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }
}
