package BackJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1966 {

    static class Node {
        int n;
        int index;

        public Node(int n, int index){
            this.n = n;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();
        int N, M;

        int T = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        int[] important;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                queue.offer(new Node(Integer.parseInt(st.nextToken()), j));
            }

            int answer = 1;
            while (!queue.isEmpty()){
                Node cur = queue.poll();
                boolean check = true;

                Iterator it = queue.iterator();
                while (it.hasNext()){
                    Node next = (Node)it.next();
                    if(cur.n < next.n){
                        check = false;
                        break;
                    }
                }
                if(!check)
                    queue.offer(cur);

                else{
                    if(cur.index == M)
                        sb.append(answer+"\n");
                    else
                        answer++;
                }
            }
        }
        System.out.print(sb);
    }
}
