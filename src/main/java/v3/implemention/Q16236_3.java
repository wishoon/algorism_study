package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Q16236_3 {
    static int N;
    static int shark_size = 2;
    static int count = 0;
    static int time = 0;
    static int[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int cur_r = 0;
        int cur_c = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cur_r = i;
                    cur_c = j;
                    map[i][j] = 0;
                }
            }
        }

        map_search(cur_r, cur_c);
        System.out.println(time);
    }

    public static void map_search(int cur_r, int cur_c) {
        // 먹이의 우선순위
        PriorityQueue<Point> feed = new PriorityQueue<>();

        // 상어의 움직임 기록
        Queue<Point> shark = new LinkedList<>();
        // 최초의 상어 시작점 등록
        shark.offer(new Point(cur_r, cur_c, 0));

        while (true) {
            // 상어가 먹이를 한 번 잡을 때까지 이동한 로그
            boolean[][] visit = new boolean[N][N];

            while (!shark.isEmpty()) {
                Point cur = shark.poll();
                visit[cur.row][cur.col] = true;

                for (int i = 0; i < 4; i++) {
                    int next_r = cur.row + dr[i];
                    int next_c = cur.col + dc[i];
                    int next_t = cur.time + 1;

                    // 범위를 벗어 나지 않거나 만약 아직 방문하지 않은 경우
                    if (range(next_r, next_c) && !visit[next_r][next_c]) {
                        // 1. map 이 0 이상인 경우
                        if (0 < map[next_r][next_c] && map[next_r][next_c] < 7) {
                            // 1.1 크기가 동일한 경우
                            if (shark_size == map[next_r][next_c]) {
                                shark.offer(new Point(next_r, next_c, next_t));
                                visit[next_r][next_c] = true;
                            }
                            // 1.2 크기가 더 작은 경우
                            else if (shark_size > map[next_r][next_c]) {
                                shark.offer(new Point(next_r, next_c, next_t));
                                feed.offer(new Point(next_r, next_c, next_t));
                                visit[next_r][next_c] = true;
                            }
                        }
                        // 2. map 이 0인 경우
                        else if (map[next_r][next_c] == 0) {
                            shark.offer(new Point(next_r, next_c, next_t));
                            visit[next_r][next_c] = true;
                        }
                    }
                }
            }

            if(!feed.isEmpty()) {
                Point eat = feed.poll();
                count++;

                if (count == shark_size) {
                    shark_size++;
                    count = 0;
                }
                shark.add(new Point(eat.row, eat.col, 0));
                map[eat.row][eat.col] = 0;
                time += eat.time;

                feed.clear();
            } else {
                break;
            }
        }
    }

    public static boolean range(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

    static class Point implements Comparable<Point> {
        int row;
        int col;
        int time;

        public Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public int compareTo(Point p) {
            if (this.time == p.time) {
                if (this.row == p.row) {
                    return this.col - p.col;
                } else {
                    return this.row - p.row;
                }
            }

            return this.time - p.time;
        }
    }

}
