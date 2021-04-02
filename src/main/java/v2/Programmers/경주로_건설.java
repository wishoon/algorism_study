package v2.Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로_건설 {
    public static void main(String[] args) {

        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        solution(board);

    }

    /*
    * 1. 기존처럼 bfs 알고리즘을 사용하여 최소가격 거리를 찾는다.
    * 2. 이때 배열 회전할 경우 500원이 들고 그냥 직선일 경우 100원이 든다.*/

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int solution(int[][] board) {
        int answer = 0;

        int[][] d = new int[board.length][board[0].length];

        answer = bfs(d, board, 0, 0);

        return answer;
    }

    public static int bfs(int[][] d, int[][] board, int x, int y) {
        int min = Integer.MAX_VALUE;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0, -1));
        d[0][0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curx = node.getX();
            int cury = node.getY();
            int cost = node.getCost();
            int curds = node.getDivision();


            if(curx == board[0].length - 1 && cury == board.length - 1) {
                min = Math.min(min, cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextx = curx + dx[i];
                int nexty = cury + dy[i];
                int nextds = i;

                // 배열 범위를 벗어 나는 경우 continue
                if(nextx < 0 || nextx >= d[0].length || nexty < 0 || nexty >= d.length)
                    continue;

                // 벽이 있는 경우 continue
                if(board[nexty][nextx] == 1)
                    continue;

                int dist = 0;
                // 차가 회전하는 경우
                if(curds == -1 || curds == i) {
                    dist = cost + 100;
                } else {
                    dist = cost + 600;
                }


                if(d[nexty][nextx] == 0) {
                    queue.offer(new Node(nextx, nexty, dist, nextds));
                    d[nexty][nextx] = dist;
                } else if(d[nexty][nextx] >= dist) {
                    queue.offer(new Node(nextx, nexty, dist, nextds));
                    d[nexty][nextx] = dist;
                }
            }
        }

        return min;
    }

    static class Node {
        private int x;
        private int y;
        private int cost;
        private int division;

        public Node(int x, int y, int cost, int division) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.division = division;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCost() {
            return cost;
        }

        public int getDivision() {
            return division;
        }
    }
}
