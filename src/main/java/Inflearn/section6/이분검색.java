package Inflearn.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        while(true) {
            int mid = (start + end) / 2;
            if(arr[mid] == M) {
                System.out.println(mid + 1);
                break;
            } else if(arr[mid] < M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}
