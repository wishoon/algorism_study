package BackJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        Stack<Character> ans = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int j = 0;
        for (int i = 1; i < N+1; i++) {
            stack.push(i);
            ans.push('+');

            while(!stack.empty() && arr[j] == stack.peek()){
                stack.pop();
                ans.push('-');
                j++;
            }
        }
        if (stack.empty()){
            for (int i=0; i<ans.size(); i++) {
                System.out.println(ans.get(i));
            }
        }
        else
            System.out.println("NO");
    }
}
