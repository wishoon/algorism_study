package Inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if(stack.isEmpty()) {
                if(c == ')') {
                    System.out.println("NO");
                    return;
                }
                stack.push(c);
            } else {
                if(c == ')') {
                    if(stack.peek() == ')') {
                        System.out.println("NO");
                        return;
                    }
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
