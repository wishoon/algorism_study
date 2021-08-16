package Inflearn.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 공통원소_구하기 {

    static int A, B;
    static int[] N;
    static int[] M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        A = Integer.parseInt(br.readLine());
        N = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            N[i] = Integer.parseInt(st.nextToken());
        }

        B = Integer.parseInt(br.readLine());
        M = new int[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            M[i] = Integer.parseInt(st.nextToken());
        }

        List answer = solution(A, B);

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    private static List solution(int a, int b) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(N);
        Arrays.sort(M);

        int left = 0, right = 0;

        while(left < a && right < b) {
            if(N[left] < M[right]) {
                left++;
            } else if(N[left] > M[right]) {
                right++;
            } else {
                list.add(N[left++]);
                right++;
            }
        }
        return list;
    }
}
