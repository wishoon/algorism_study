package Inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if(c == '(' || c == ')') {
                if(c == '(') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            } else {
                if(stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
    }
}
