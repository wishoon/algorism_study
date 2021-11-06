package v3.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length - 1;
        int sum = 0;
        int cnt = 0;
        while (lt < rt) {
            sum = arr[lt] + arr[rt];

            if(sum == x) {
                cnt++;
                lt++;
            }
            else if(sum < x) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(cnt);
    }
}
