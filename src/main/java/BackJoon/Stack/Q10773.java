package BackJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                stack.pop();
            }
            else {
                stack.push(temp);
            }
        }
        int sum = 0;

        for (int num: stack) {
            sum += num;
        }
        System.out.println(sum);
    }
}
