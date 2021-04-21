package v2.Programmers;

import org.junit.jupiter.api.Test;

public class 외벽_점검 {
    public static void main(String[] args) {

        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};

        solution(n, weak, dist);
    }

    static int N, MIN;
    static int[] Weak;
    static int[] Dist;
    static int[][] RotateWeak;
    static boolean[] visit;

    public static int solution(int n, int[] weak, int[] dist) {

        N = n;
        Weak = weak;
        Dist = dist;
        RotateWeak = new int[weak.length][weak.length];
        visit = new boolean[dist.length];
        MIN = Integer.MAX_VALUE;

        rotate();

        for (int i = 1; i <= Dist.length; i++) {
            permutation(0, i, "");
        }

        return MIN == Integer.MAX_VALUE ? -1 : MIN;
    }

    private static void permutation(int cnt, int depth, String s) {
        if(cnt == depth) {
            check(s.trim().split(" "));

            return;
        }

        for(int i = 0; i < Dist.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                permutation(cnt + 1, depth,s + Dist[i] + " ");
                visit[i] = false;
            }
        }
    }

    private static void check(String[] s) {
        int people[] = new int[s.length];
        for(int i = 0; i < s.length; i++) {
            people[i] = Integer.parseInt(s[i]);
        }

        // rotate에 있는 배열들을 하나씩 검사
        for (int i = 0; i < RotateWeak.length; i++) {

            int index = 0;
            int start = RotateWeak[i][index];

            for (int j = 0; j < s.length; j++) {
                while (index < RotateWeak.length && RotateWeak[i][index] - start <= people[j] ) {
                    index++;
                }
                if (index >= RotateWeak.length) {
                    MIN = Math.min(MIN, people.length);
                } else {
                    start = RotateWeak[i][index];
                }
            }
        }
    }

    // Weak 경우의 수
    private static void rotate() {
        for (int i = 0; i < Weak.length; i++) {

            int ro[] = new int[Weak.length];
            int index = i;

            for (int j = 0; j < Weak.length; j++) {
                ro[j] = Weak[index % Weak.length];

                if(index >= Weak.length){
                    ro[j] += N;
                }
                index++;
            }
            RotateWeak[i] = ro;
        }
    }

    @Test
    public void Test() {

    }
}

