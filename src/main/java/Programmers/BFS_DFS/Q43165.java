package Programmers.BFS_DFS;

public class Q43165 {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = 0;
        answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);
        System.out.println(answer);
    }

    public static int dfs(int[] numbers, int target, int sum, int i){

        if(i == numbers.length){
            if(sum == target){
                return 1;
            } else
                return 0;
        }

        int result = 0;
        result += dfs(numbers, target, sum+numbers[i], i+1);
        result += dfs(numbers, target, sum-numbers[i], i+1);

        return result;
    }
}
