package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13460_3 {
    static int N, M;
    static char[][] map;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new char[N][M];
        int r_row = 0, r_col = 0, b_row = 0, b_col = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'R') {
                   r_row = i;
                   r_col = j;
                }
                if (map[i][j] == 'B') {
                    b_row = i;
                    b_col = j;
                }
            }
        }
        int answer = marble_escape(r_row, r_col, b_row, b_col);
        System.out.println(answer);
    }

    private static int marble_escape(int r_row, int r_col, int b_row, int b_col) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r_row, r_col, b_row, b_col, 0));
        boolean[][][][] visit = new boolean[N][M][N][M];
        visit[r_row][r_col][b_row][b_col] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 10번 이상 움직인 경우
            if (cur.time > 10) {
                return -1;
            }

            // 파란 공이 빠진 경우
            if (map[cur.b_row][cur.b_col] == 'O') {
                continue;
            }
            // 빨간 공이 빠진 경우 이면서 파란 공이 빠지지 않은 경우
            if (map[cur.r_row][cur.r_col] == 'O' && map[cur.b_row][cur.b_col] != 'O') {
                return cur.time;
            }

            for (int i = 0; i < 4; i++) {
                int next_r_row = cur.r_row;
                int next_r_col = cur.r_col;

                while (true) {
                    next_r_row += dr[i];
                    next_r_col += dc[i];

                    if (map[next_r_row][next_r_col] == 'O' || map[next_r_row][next_r_col] == '#') {
                        break;
                    }
                }

                if (map[next_r_row][next_r_col] == '#') {
                    next_r_row -= dr[i];
                    next_r_col -= dc[i];
                }

                int next_b_row = cur.b_row;
                int next_b_col = cur.b_col;

                while (true) {
                    next_b_row += dr[i];
                    next_b_col += dc[i];

                    if (map[next_b_row][next_b_col] == 'O' || map[next_b_row][next_b_col] == '#') {
                        break;
                    }
                }

                if (map[next_b_row][next_b_col] == '#') {
                    next_b_row -= dr[i];
                    next_b_col -= dc[i];
                }

                // 빨간 공이 파란 공과 겹치는 위치가 된 경우
                if (next_b_row == next_r_row && next_b_col == next_r_col && map[next_r_row][next_r_col] != 'O') {
                    int red_distance = Math.abs(cur.r_row - next_r_row) + Math.abs(cur.r_col - next_r_col);
                    int blue_distance = Math.abs(cur.b_row - next_b_row) + Math.abs(cur.b_col - next_b_col);

                    if (red_distance > blue_distance) {
                        next_r_row -= dr[i];
                        next_r_col -= dc[i];
                    } else {
                        next_b_row -= dr[i];
                        next_b_col -= dc[i];
                    }

                }

                if (!visit[next_r_row][next_r_col][next_b_row][next_b_col]) {
                    visit[next_r_row][next_r_col][next_b_row][next_b_col] = true;
                    queue.offer(new Node(next_r_row, next_r_col, next_b_row, next_b_col, cur.time + 1));
                }
            }
        }

        return -1;
    }

    static class Node {
        int r_row;
        int r_col;
        int b_row;
        int b_col;
        int time;

        public Node(int r_row, int r_col, int b_row, int b_col, int time) {
            this.r_row = r_row;
            this.r_col = r_col;
            this.b_row = b_row;
            this.b_col = b_col;
            this.time = time;
        }
    }
}
