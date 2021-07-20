package BackJoon.samsung.시간복잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {

    static int N, S;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = 0, length = 0, min = Integer.MAX_VALUE;
        sum = nums[0];

        while (true) {
            if (sum >= S) {
                length = Math.abs(right) - Math.abs(left) + 1;
                min = Math.min(length, min);
                sum -= nums[left++];
            } else {
                sum += nums[++right];
            }

            if(right == N || left == N) {
                break;
            }
        }

        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }

}
