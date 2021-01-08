package BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14888 {

    public static int N;    // 숫자 갯수
    public static int[] number; // 숫자
    public static int[] operator = new int[4];  // 연산자 갯수
    public static int min = Integer.MAX_VALUE;  // 최솟값
    public static int max = Integer.MIN_VALUE;  // 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        String input[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(input[i]);
        }
        String input1[] = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(input1[i]);
        }

        dfs(number[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int index) {
        if(index == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                // 해당 연산자를 1 감소시킨다.
                operator[i]--;

                switch (i) {
                    case 0: dfs(num + number[index], index + 1); break;
                    case 1: dfs(num - number[index], index + 1); break;
                    case 2: dfs(num * number[index], index + 1); break;
                    case 3: dfs(num / number[index], index + 1); break;
                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }
}
