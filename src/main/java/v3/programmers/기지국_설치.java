package v3.programmers;

public class 기지국_설치 {
    public static void main(String[] args) {

        int n = 16;
        int[] stations = {9};
        int w = 2;

        solution(n, stations, w);
    }

    public static void solution(int n, int[] stations, int w) {

        int answer = 0;
        int cur = 1;
        int dist = 0;
        int st = 0, et = 0;
        for (int i = 0; i < stations.length; i++) {
            // 전파가 미치는 범위
            st = stations[i] - w;
            et = stations[i] + w;

            if (cur >= st) {
                cur = et + 1;
            }
            else if (cur < st) {
                dist = st - cur;
                if (dist % ((w * 2) + 1) == 0) {
                    answer += dist / ((w * 2) + 1);
                } else {
                    answer += dist / ((w * 2) + 1);
                    answer += 1;
                }
                cur = et + 1;
            }
        }

        // n 보다 현재 위치가 작을 확률이 있으므로
        if (cur <= n) {
            dist = n + 1 - cur;
            if (dist % ((w * 2) + 1 )== 0) {
                answer += dist / ((w * 2) + 1);
            } else {
                answer += dist / ((w * 2) + 1);
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
