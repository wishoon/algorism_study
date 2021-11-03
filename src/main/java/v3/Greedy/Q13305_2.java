package v3.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13305_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Long[] city_cost = new Long[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            city_cost[i] = Long.parseLong(st.nextToken());
        }


        long[] oil_cost = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oil_cost[i] = Long.parseLong(st.nextToken());
        }


        long min = oil_cost[0];
        long answer_cost = 0;
        for (int i = 0; i < n - 1; i++) {
            if (min > oil_cost[i]) {
                min = oil_cost[i];
            }
            answer_cost += min * city_cost[i];
        }

        System.out.println(answer_cost);
    }
    /*
    만약 주유소의 기름이 다음 도시의 기름보다 비싸다면
    -> 다음 도시를 갈 만큼만 충전

    만약 주유소의 기름이 다음 도시의 기름보다 최고 싸다면
    -> 무조건 풀 충전
     */
}
