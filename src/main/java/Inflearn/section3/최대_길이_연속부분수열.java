package Inflearn.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_길이_연속부분수열 {

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

        int lt = 0;
        int cnt_K = 0;
        int answer = 0;

        for (int rt = 0; rt < N; rt++) {
            if(arr[rt] == 0) {
                if(cnt_K < K) {
                    cnt_K++;
                } else {
                    while (arr[lt++] != 0) {

                    }
                }
            }
            answer = Math.max(answer, rt - lt + 1);
//            System.out.println(answer + " " + (rt - lt + 1) + " " + rt + " " + lt);
        }

        System.out.println(answer);
    }
}
