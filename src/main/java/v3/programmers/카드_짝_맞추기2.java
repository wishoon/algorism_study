package v3.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 카드_짝_맞추기2 {

    static int[][] board_c;
    public static void main(String[] args) {

        int[][] board = {{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}};
        int r = 1;
        int c = 0;

        solution(board, r, c);
    }

    public static int solution(int[][] board, int r, int c) {

        int answer = 0;

        board_c = board;
        answer = permutation(new Point(r, c, 0));

        System.out.println(answer);
        return answer;
    }

    // 문제에서 주어진 카드는 1 ~ 6 이다.
    public static int permutation(Point point) {

        int ret = Integer.MAX_VALUE;
        for (int num = 1; num <= 6; num++) {
            List<Point> card = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if(board_c[i][j] == num) {
                        card.add(new Point(i, j, 0));
                    }
                }
            }

            if (card.isEmpty()) {
                continue;
            }
            int one = bfs(point, card.get(0)) + bfs(card.get(0), card.get(1)) + 2;
            int two = bfs(point, card.get(1)) + bfs(card.get(1), card.get(0)) + 2;

            for (int i = 0; i < 2; i++) {
                board_c[card.get(i).row][card.get(i).col] = 0;
            }

            ret = Math.min(ret, one + permutation(card.get(1)));
            ret = Math.min(ret, two + permutation(card.get(0)));

            for (int i = 0; i < 2; i++) {
                board_c[card.get(i).row][card.get(i).col] = num;
            }
        }

        if(Integer.MAX_VALUE == ret) {
            return 0;
        }

        return ret;
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(Point start, Point end) {

        int bfs_answer = 0;
        boolean[][] visited = new boolean[4][4];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if(cur.row == end.row && cur.col == end.col) {

                bfs_answer = cur.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.row + dx[i];
                int nc = cur.col + dy[i];

                if(nr < 0 || nr > 3 || nc < 0 || nc > 3) {
                    continue;
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Point(nr, nc, cur.cnt + 1));
                }

                for (int j = 0; j < 2; j++) {
                    if(board_c[nr][nc] != 0) {
                        break;
                    }
                    if(nr + dx[i] < 0 || nr + dx[i] > 3 || nc + dy[i] < 0 || nc + dy[i] > 3) {
                        break;
                    }
                    nr += dx[i];
                    nc += dy[i];
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Point(nr, nc, cur.cnt + 1));
                }
            }
        }

        return bfs_answer;
    }

    static class Point {
        int row;
        int col;
        int cnt;

        public Point(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }

        public Point(Point point) {
            this.row = point.row;
            this.col = point.col;
            this.cnt = point.cnt;
        }
    }
}
