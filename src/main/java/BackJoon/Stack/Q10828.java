package BackJoon.Stack;

import java.io.*;
import java.util.Stack;

public class Q10828 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            if(arr[i].contains("push")){
                String str[] = arr[i].split(" ");
                stack.push(Integer.parseInt(str[1]));
            }
            else if(arr[i].contains("pop")){
                if(stack.empty()){
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            }
            else if(arr[i].contains("size")){
                System.out.println(stack.size());
            }
            else if(arr[i].contains("empty")){
                if(stack.empty()){
                    System.out.println(1);
                }else
                    System.out.println(0);
            }
            else if(arr[i].contains("top")){
                if(stack.empty()){
                    System.out.println(-1);
                }else
                    System.out.println(stack.peek());
            }
        }

    }
}
