package BackJoon.Stack;


import java.io.*;
import java.util.Stack;

public class Q17298 {
    public static void main(String[] args) throws IOException {
        // 시간 초과 빌드
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        String input[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < N; i++) {
            int temp = stack.get(i);
            int count = 0;
            for (int j = i; j < stack.size(); j++) {
                if(temp < stack.get(j)) {
                    count++;
                    temp = stack.get(j);
                    System.out.print(temp + " ");
                    break;
                }
            }
            if(count==0)
                System.out.print(-1 + " ");
        }*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];

        Stack<Integer> stack = new Stack<>();

        String input[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        stack.push(0);
        for(int i = 1; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
            result[stack.pop()] = -1;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++)
            bw.write(result[i] + " ");// 출력한다

        bw.write("\n");
        bw.flush();
    }
}
