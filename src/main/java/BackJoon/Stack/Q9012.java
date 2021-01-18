package BackJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());
        String[] arr = new String[T];

        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < T; i++) {
            int count = 0;
            stack = new Stack<>();
            for (int j = 0; j < arr[i].length(); j++) {
                if(arr[i].charAt(j) == '(') {
                    count++;
                    stack.push(arr[i].charAt(j));
                } else{
                    if(stack.empty()){
                        count++;
                        break;
                    }
                    stack.pop();
                    count--;
                }
            }
            if(count!=0){
                System.out.println("NO");
            }
            else
                System.out.println("YES");
        }
    }
}
