package Programmers.DP;

public class Q43105 {

    static Integer dp[][];
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        dp = new Integer[triangle.length][triangle.length];

        System.out.println(dp(0, 0, triangle));
    }

    public static int dp(int depth, int index, int[][] triangle){
        if(depth == triangle.length - 1)
            return triangle[depth][index];

        if(dp[depth][index] == null) {
            dp[depth][index] = Math.max(dp(depth + 1, index, triangle), dp(depth + 1, index + 1, triangle)) + triangle[depth][index];
        }

        return dp[depth][index];
    }
}


