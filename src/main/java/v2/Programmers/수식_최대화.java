package v2.Programmers;

public class 수식_최대화 {
    public static void main(String[] args) {

        String expression = "50*6-3*2";
        long answer = solution(expression);
    }

    static char[] c;
    static int[] operation;
    static int max = Integer.MIN_VALUE;
    public static long solution(String expression) {
        long answer = 0;

        operation = new int[3];

        // operation[0] : +, operation[1] : -, operation[2] : *

        c = expression.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c.length; i++) {
            if(c[i] == '+'){
                sb.append(" ");
                operation[0]++;
            } else if(c[i] == '-') {
                sb.append(" ");
                operation[1]++;
            } else if(c[i] == '*') {
                sb.append(" ");
                operation[2]++;
            } else {
                sb.append(c[i]);
            }
        }

        String[] nums = sb.toString().split(" ");

        // dfs
//        dfs(Integer.parseInt(nums[0]), 1, nums, nums.length);


        System.out.println(max);
        return answer;
    }

//    public static void dfs(int num, int depth, String[] nums, int end) {
//        if(depth == end) {
//            System.out.println(num);
//            max = Math.max(max, Math.abs(num));
//
//            return;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            if(operation[i] > 0) {
//                operation[i]--;
//                switch (i) {
//                    case 0: dfs(num + Integer.parseInt(nums[depth]), depth + 1, nums, end); break;
//                    case 1: dfs(num - Integer.parseInt(nums[depth]), depth + 1, nums, end); break;
//                    case 2: dfs(num * Integer.parseInt(nums[depth]), depth + 1, nums, end); break;
//                }
//                operation[i]++;
//            }
//        }
//    }
}
