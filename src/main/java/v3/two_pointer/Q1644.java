package v3.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 에라토스네스의 체로 소수 배열을 구한다.
        // 이후 소수 배열을 만들고 부분합을 구한다.

        int[] prime = new int[n + 1];
        prime[0] = 1; prime[1] = 1;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i] == 0) {
                for (int j = i * i; j <= n; j = j + i) {
                    prime[j] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < prime.length; i++) {
            if(prime[i] == 0) {
                list.add(i);
//                System.out.print(i + " ");
            }
        }
//        System.out.println();

        int lt = 0, rt = 0;
        int cnt = 0;
        int sum = 0;

        while (true) {
            if(sum >= n) {
                if(sum == n) {
                    cnt++;
//                    System.out.println(lt + " " + rt);
                }
                sum -= list.get(lt++);
            } else if (rt == list.size()) {
                break;
            } else {
                sum += list.get(rt++);
            }
        }

        System.out.println(cnt);
    }
}
