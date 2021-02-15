package Programmers.DP;

import java.util.HashSet;

public class Q42895 {
    public static void main(String[] args) {

    }
    static HashSet<Integer>[] dp = new HashSet[9];
    static int _n;
    public int solution(int N, int number){
        int answer = 0;
        _n = N;
        for (int i = 1; i <= 8 ; i++) {
            solve(i);
            if(dp[i].contains(number))
                return i;
        }
        return -1;
    }

    public HashSet<Integer> solve(int n) {
        if((dp[n] != null) && !dp[n].isEmpty())
            return dp[n];

        int num = 0;
        // nnn... 을 구하기 위함
        for (int i = 0; i < n; i++) {
            num = 10 * num + _n;
        }
        HashSet<Integer> temp = new HashSet<>();
        temp.add(num);

        for (int i = 1; i < n; i++) {
            int j = n - i;
            HashSet<Integer> from = solve(i);
            HashSet<Integer> to = solve(j);
            for (int n1 : from) {
                for (int n2 : to) {
                    temp.add(n1 + n2);
                    temp.add(n1 - n2);
                    temp.add(n1 * n2);
                    if(n2 != 0)
                        temp.add(n1 / n2);
                }
            }
        }

        return dp[n] = temp;
    }
}
