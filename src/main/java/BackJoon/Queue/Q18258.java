package BackJoon.Queue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int last = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            if(cmd.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                last = num;
            }
            else if(cmd.equals("front")){
                if(queue.isEmpty()){
                    sb.append(-1 + "\n");
                }
                else {
                    sb.append(queue.peek() + "\n");
                }
            }
            else if(cmd.equals("back")){
                if(queue.isEmpty()){
                    sb.append(-1 + "\n");
                }
                else {
                    sb.append(last + "\n");
                }
            }
            else if(cmd.equals("size")){
                sb.append(queue.size() + "\n");
            }
            else if(cmd.equals("empty")){
                if(queue.isEmpty()){
                    sb.append(1 + "\n");
                }
                else{
                    sb.append(0 + "\n");
                }
            }
            else if(cmd.equals("pop")){
                if(queue.isEmpty()){
                    sb.append(-1 + "\n");
                }
                else{
                    sb.append(queue.poll() + "\n");
                }
            }
        }
        System.out.print(sb);
    }
}
