package BackJoon.samsung.알고리즘기초;

import java.util.*;
import java.io.*;

public class 탈출 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R, C;
    static char[][] arr;
    static int[][] dp;
    static Queue<Pot> queue = new LinkedList<>();
    static boolean foundAnswer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        dp = new int[R][C];
        for (int r = 0; r < R; r++) {
            char[] input = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                arr[r][c] = input[c];
            }
        }

        // 물의 시작점과 고슴도치의 시작점을 queue에 대입

        int sr = 0, sc = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (arr[r][c] == 'S') {
                    sr = r;
                    sc = c;
                } else if (arr[r][c] == '*') {
                    queue.add(new Pot(r, c, '*'));
                }
            }
        }
        queue.add(new Pot(sr, sc, 'S'));

        while (!queue.isEmpty()) {
            Pot p = queue.poll();

            // 2번 고민에 대한 로직
            if (p.type == 'D') {
                System.out.println(dp[p.y][p.x]);
                foundAnswer = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + p.y;
                int nx = dx[i] + p.x;

                if (0 <= nx && nx < C && 0 <= ny && ny < R) {
                    if (p.type == '*') {
                        if (arr[ny][nx] == '.' || arr[ny][nx] == 'S') {
                            arr[ny][nx] = '*';
                            queue.add(new Pot(ny, nx, '*'));
                        }
                    } else {
                        if (arr[ny][nx] == '.' || arr[ny][nx] == 'D') {
                            if (dp[ny][nx] == 0) {
                                dp[ny][nx] = dp[p.y][p.x] + 1;
                                // 다음표식('.', 'D')를 저장하기 위해서
                                queue.add(new Pot(ny, nx, arr[ny][nx]));
                            }
                        }
                    }
                }
            }
        }

        if (!foundAnswer) {
            System.out.println("KAKTUS");
        }
    }

    static class Pot {
        private int y;
        private int x;
        private char type;

        public Pot(int y, int x, char type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
}