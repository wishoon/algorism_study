package v2.BackJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {
    public static void main(String[] args) throws IOException {
        int n = 0, k = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        solution1(n, k, br);

        solution2(n, k, br);

    }

    public static void solution1(int n, int k, BufferedReader br) throws IOException {

        int index = 0;
        int count = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] < k) {
                index = i;
            }
        }

        while (k != 0) {
            if(index < 0)
                break;
            if(k - arr[index] >= 0) {
                k = k - arr[index];
                count++;
            } else {
                index--;
            }
        }
        System.out.println(count);
    }

    public static void solution2(int n, int k, BufferedReader br) throws IOException {

        int[] arr = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i >= 0 ; i--) {
            answer += k / arr[i];
            k %= arr[i];
        }

        System.out.println(answer);
    }
}


