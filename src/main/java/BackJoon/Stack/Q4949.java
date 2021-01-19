package BackJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){

            String str = br.readLine();
            if(str.equals("."))
                break;
            sb.append(solve(str)).append('\n');
        }
        System.out.println(sb);
    }

    public static String solve(String str){

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '[' || str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i) == ')'){
                if(stack.empty() || stack.peek() != '(')
                    return "no";
                else
                    stack.pop();
            }
            else if(str.charAt(i) == ']'){
                if(stack.empty() || stack.peek() != '[')
                    return "no";
                else
                    stack.pop();
            }
        }
        if(stack.empty()){
            return "yes";
        } else {
            return "no";
        }
    }
}
