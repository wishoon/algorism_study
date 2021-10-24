package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503 {

    static int r, c;
    static int sr, sc, sd;
    // 북, 동, 남, 서 방향
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    // 최종 카운트
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        // 0은 북쪽, 1은 동쪽, 2는 남족, 3은 서쪽
        sd = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(sr, sc, sd, map);
        System.out.println(cnt);
    }

    public static void dfs(int cr, int cc, int d, int[][] map) {

        // 현재 위치 청소
        map[cr][cc] = 2;

        for (int i = 0; i < 4; i++) {

            // 왼쪽 방향으로 돌면서 탐색
            d -= 1;
            if(d == -1) {
                d = 3;
            }
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
                if (map[nr][nc] == 0) {
                    cnt++;
                    dfs(nr, nc, d, map);

                    // 일반적인 dfs 와는 다르게 후진 상태 로직을 처리 해 줘야 하기 때문에 종료
                    return;
                }
            }
        }
        // 반대 방향으로 후진을 하기 위한 계산
        int bd = (d + 2) % 4;
        int br = cr + dr[bd];
        int bc = cc + dc[bd];

        if (br >= 0 && br < r && bc >= 0 && bc < c && map[br][bc] != 1) {
            dfs(br, bc, d, map);
        }
    }
}
