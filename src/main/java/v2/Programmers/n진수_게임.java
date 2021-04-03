package v2.Programmers;

public class n진수_게임 {
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;

        solution(n, t, m, p);
    }
    public static String solution(int n, int t, int m, int p) {
        String answer = "";

        int i = 1;
        StringBuffer sb = new StringBuffer();
        sb.append(0);

        while (sb.length() < m * t) {   // m * t를 참가 인원의 갯수 * 미리 구해야 할 숫자의 갯
            sb.append(notation(i++, n));
        }

        // 튜브가 말해야 하는 숫자
        for (int j = p - 1; j < m * t; j += m) {
            answer += sb.charAt(j);
        }

        System.out.println(answer);
        return answer;
    }

    public static String notation(int num, int n) {
        String nstr = "";
        while (num != 0) {
            if (num % n < 10) { // 10 진수 이하 일 경우
                nstr = num % n + nstr;
            } else {    // 10 진수 이상 일 경우
                nstr = String.valueOf((char)(num % n + 55)) + nstr;
            }

            num /= n;
        }

        return nstr;
    }
}
