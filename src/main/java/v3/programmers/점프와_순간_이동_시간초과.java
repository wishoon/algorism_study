package v3.programmers;

import java.util.PriorityQueue;

public class 점프와_순간_이동_시간초과 {
    public static void main(String[] args) {

        int n = 15;

        solution(n);
    }

    public static int solution(int n) {

        int ans = 0;
        ans = bfs(0, n);

        System.out.println(ans);

        return ans;
    }

    public static int bfs(int start, int end) {

        int result = Integer.MAX_VALUE;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start + 1, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur_num = node.num;
            int cur_cnt = node.cnt;

            if (cur_num == end) {
                result = cur_cnt;
                break;
            }

            if (cur_num > end) {
                continue;
            }
            queue.offer(new Node(node.num + 1, node.cnt + 1));
            queue.offer(new Node(node.num * 2, node.cnt));
        }

        return result;
    }

    static class Node implements Comparable<Node>{
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node node) {
            return this.cnt - node.cnt;
        }
    }

    /*

     */
}
