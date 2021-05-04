package v2.Programmers;

public class 타겟_넘버 {
    static int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return answer;
    }

    static void dfs(int[] numbers, int target, int count, int sum) {

        if(count == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        } else if(count < numbers.length) {
            dfs(numbers, target, count + 1, sum + numbers[count]);
            dfs(numbers, target, count + 1, sum - numbers[count]);
        }
    }
}
