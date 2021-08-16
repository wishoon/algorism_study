package Inflearn.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두_배열_합치기 {
    static int N, M;
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(N, M);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] solution(int n, int m) {
        int[] answer = new int[n + m];

        int cnt = 0;
        int left = 0, right = 0;

        while(left < n && right < m) {
            if(arr1[left] < arr2[right]) {
                answer[cnt++] = arr1[left++];
            } else {
                answer[cnt++] = arr2[right++];
            }
        }
        while(left < n) {
            answer[cnt++] = arr1[left++];
        }
        while(right < m) {
            answer[cnt++] = arr2[right++];
        }

        return answer;
    }
}
