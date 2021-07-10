package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대_매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        String[] arr = br.readLine().split(" ");

        solution(input, arr);
    }

    private static int solution(String[] input, String[] arr) {

        int answer = 0, sum = 0;
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        for (int i = 0; i < k; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        answer = sum;
        for (int i = k; i < n; i++) {
            sum += (Integer.parseInt(arr[i]) - Integer.parseInt(arr[i - k]));
        }
        answer = Math.max(answer, sum);

        return answer;
    }
}
