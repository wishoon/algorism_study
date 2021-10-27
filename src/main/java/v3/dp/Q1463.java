package v3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.num == 1) {
                System.out.println(node.cnt);
                break;
            }
            if (node.num % 3 == 0) {
                queue.offer(new Node(node.num / 3, node.cnt + 1));
            }

            if (node.num % 2 == 0) {
                queue.offer(new Node(node.num / 2, node.cnt + 1));
            }

            queue.offer(new Node(node.num - 1, node.cnt + 1));
        }
    }

    static class Node {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
