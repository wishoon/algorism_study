package v3.programmers;

public class 점프와_순간_이동 {
    public static void main(String[] args) {

        int n = 5000;
        int answer =  solution(n);
        System.out.println(answer);
    }

    public static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            // n이 짝수인 경우
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}
