package v3.programmers;


public class 지형_편집 {
    public static void main(String[] args) {
        int[][] land = {{4, 4, 3}, {3, 2, 2}, {2, 1, 0}};
        int P = 5;
        int Q = 3;

        solution(land, P, Q);
    }

    public static long solution(int[][] land, int P, int Q) {

        long answer = Long.MAX_VALUE;

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                min = Long.min(min, land[i][j]);
                max = Long.max(max, land[i][j]);
            }
        }

        long st = min, et = max;
        long mid;

        while (st <= et) {
            mid = (st + et) / 2;

            long r1 = getCost(mid, P, Q, land);
            long r2 = getCost(mid + 1, P, Q, land);

            if (r1 <= r2) {
                answer = Math.min(answer, r1);
                et = mid - 1;
            } else {
                answer = Math.min(answer, r2);
                st = mid + 1;
            }
        }
        System.out.println(answer);

        return answer;
    }

    public static long getCost(long mid, int p, int q, int[][] land) {

       long cost = 0;

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] < mid) {
                    cost += (mid - land[i][j]) * p;
                } else if (land[i][j] > mid) {
                    cost += (land[i][j] - mid) * q;
                }
            }
        }

        return cost;
    }
}
