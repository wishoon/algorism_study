package v2.Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 수식_최대화_다시 {

    static long[] n;
    static ArrayList<Character> oper;

    // 정의한 3개 연산자의 우선순위
    static int[][] operPr = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
    static Map<Character, Integer> map;

    public static void main(String[] args) {
        String str = "100-200*300-500+20";
        System.out.println(solution(str));
    }

    public static long solution(String str) {
        oper = new ArrayList<>();

        map = new HashMap<>();
        map.put('-', 0);
        map.put('+', 1);
        map.put('*', 2);

        char[] c = str.toCharArray();

        // 연산식을 돌면서 연산자인 경우 숫자분리를 위해 ' '로 바꿔주고, 연산자는 따로 저징
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c.length; i++) {
            if(c[i] == '+'){
                c[i] = ' ';
                oper.add('+');
            } else if(c[i] == '-'){
                c[i] = ' ';
                oper.add('-');
            } else if(c[i] == '*'){
                c[i] = ' ';
                oper.add('*');
            }
            sb.append(c[i]);
        }

        String[] nums = sb.toString().split(" ");
        n = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            n[i] = Integer.parseInt(nums[i]);
        }

        // 연산자 우선순위
        long answer = 0;
        for (int i = 0; i < operPr.length; i++) {
            // 현재 openPr 우선순위로 조합을 구성
            long result = Math.abs(getValue(operPr[i]));
            answer = Math.max(answer, result);
        }

        return answer;
    }

    public static long getValue(int[] ops) {
        ArrayList<Long> number = new ArrayList<>();
        ArrayList<Character> opers = new ArrayList<>();

        // 각 숫자값과 연산기호 초기화
        for (int i = 0; i < oper.size(); i++) {
            opers.add(oper.get(i));
        }
        for (int i = 0; i < n.length; i++) {
            number.add(n[i]);
        }

        for (int i = 2; i > -1; i--) {
            for (int j = 0; j < opers.size(); j++) {
                if(ops[map.get(opers.get(j))] == i) {
                    long a = number.remove(j);
                    long b = number.remove(j);
                    long result = operation(opers.get(j), a, b);
                    number.add(j, result);
                    opers.remove(j);
                    j--;
                }
            }
        }
        return number.remove(0);
    }

    public static long operation(char op, long a, long b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }
}
