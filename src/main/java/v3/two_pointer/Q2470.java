package v3.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int lt = 0, rt = arr.length - 1;
        int answer1 = 0, answer2 = 0;

        int min = Integer.MAX_VALUE;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];

            if (min > Math.abs(sum)){
                min = Math.abs(sum);
                answer1 = lt;
                answer2 = rt;

                if (sum == 0) {
                    break;
                }
            }

            if (sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(arr[answer1] + " " + arr[answer2]);
    }
}
