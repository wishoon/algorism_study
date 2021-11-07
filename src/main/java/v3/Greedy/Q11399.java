package v3.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11399 {

    static int n;
    static int[] person_time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        person_time = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            person_time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(person_time);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i ; j++) {
                sum += person_time[j];
            }
            answer += sum;
        }

        System.out.println(answer);
    }
}
