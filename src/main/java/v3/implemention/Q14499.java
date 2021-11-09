package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14499 {

    static int N, M, x, y, K;
    static int[][] map;
    // 9는 주사위가 아님, 0이면 주사위에 값이 없는 상태, 1 ~ 6이면 주사위에 값이 있는 상태
    static int[] dice = new int[7];
    static int[] order;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        int cur_x = x, cur_y = y;
        for (int i = 0; i < K; i++) {
            int order_element = order[i];

            int next_x = cur_x + dx[order_element - 1];
            int next_y = cur_y + dy[order_element - 1];

            if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= M) {
                continue;
            }
            moveDice(dice, order_element);

            if (map[next_x][next_y] == 0) {
                map[next_x][next_y] = dice[6];
            } else if (map[next_x][next_y] != 0) {
                dice[6] = map[next_x][next_y];
                map[next_x][next_y] = 0;
            }

            cur_x = next_x;
            cur_y = next_y;
            System.out.println(dice[1]);
        }

    }

    public static void moveDice(int[] dice, int order) {
        int[] temp = dice.clone();
        // 1 - 동쪽, 2 - 서쪽, 3 - 북쪽, 4 - 남쪽
        if (order == 1) {
            dice[4] = temp[6];
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[6] = temp[3];
        } else if (order == 2) {
            dice[4] = temp[1];
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[6] = temp[4];
        } else if (order == 3) {
            dice[2] = temp[1];
            dice[1] = temp[5];
            dice[5] = temp[6];
            dice[6] = temp[2];
        } else if (order == 4) {
            dice[2] = temp[6];
            dice[1] = temp[2];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
    }
}
