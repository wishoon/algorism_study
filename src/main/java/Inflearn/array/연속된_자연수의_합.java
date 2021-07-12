package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된_자연수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    private static int solution(int n) {
        int limit = n / 2 + 1;

        int lt = 1;
        int sum = 0;
        int answer = 0;
        for (int rt = 1; rt <= limit; rt++) {

            sum += rt;

            if(n == sum) {
                answer++;
            }

            while(sum >= n) {
                sum -= lt++;

                if(n == sum) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
