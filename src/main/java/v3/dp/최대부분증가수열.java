package v3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대부분증가수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(arr);
    }

    public static void solution(int[] arr) {
        int answer = 0;
        int[] dy = new int[arr.length];

        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;

            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}
