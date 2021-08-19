package Inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack();

        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                if(str.charAt(i - 1) == '(') {
                    stack.pop();
                    cnt += stack.size();
                } else {
                    // 막대기의 끝
                    stack.pop();
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}
