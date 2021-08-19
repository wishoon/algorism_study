package Inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위식_연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if(1 <= c - '0' && c - '0' <= 9) {
                stack.push(c - '0');
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                int result = 0;
                if(c == '+') {
                    result = lt + rt;
                } else if(c == '-') {
                    result = lt - rt;
                } else if(c == '*') {
                    result = lt * rt;
                } else if(c == '/') {
                    result = lt / rt;
                }
                stack.push(result);
            }
        }

        System.out.println(stack.pop());
    }
}
