package v3.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {

    static int n;
    static int[] num;
    static int[] cal;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        cal = new int[4];
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        int[] log = new int[n - 1];
        backtracking(log, 0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void backtracking(int[] log, int depth) {
        if(depth == n - 1) {
            calculation(log);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(cal[i] != 0) {
                log[depth] = i;
                cal[i]--;
                backtracking(log, depth + 1);
                cal[i]++;
            }
        }
    }

    public static void calculation(int[] log) {
        int sum = num[0];
        for (int i = 0; i < n - 1; i++) {
            if(log[i] == 0) {
                sum += num[i + 1];
            } else if(log[i] == 1) {
                sum -= num[i + 1];
            } else if(log[i] == 2) {
                sum *= num[i + 1];
            } else if(log[i] == 3) {
                if(num[i + 1] < 0) {
                    sum /= Math.abs(num[i + 1]);
                    sum *= -1;
                } else {
                    sum /= num[i + 1];
                }
            }
        }

        min = Math.min(min, sum);
        max = Math.max(max, sum);
    }
}
