package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206_1 {

    static class Place {
        int y;
        int x;
        int move;
        int drill;

        public Place(int y, int x, int move, int drill){
            this.y = y;
            this.x = x;
            this.move = move;
            this.drill = drill;
        }
    }

    private static int[] dx = {-1, 1, 0 ,0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] isVisited;
    private static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                isVisited[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0, 0);
        if(ans == 0){
            System.out.println(-1);
        } else
            System.out.println(ans);
    }

    public static void bfs(int y, int x){
        Queue<Place> q = new LinkedList<>();
        q.add(new Place(y, x, 1, 0));
        isVisited[y][x] = 0;

        while (!q.isEmpty()){

            Place p = q.poll();

            if(p.x == M-1 && p.y == N-1){
                ans = p.move;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(ny<0 || nx<0 || ny>=N || nx>=M)
                    continue;
                if(isVisited[ny][nx] > p.drill){
                    if(map[ny][nx] == 0){
                        isVisited[ny][nx] = p.drill;
                        q.add(new Place(ny, nx, p.move+1, p.drill));
                    } else{
                        if(p.drill == 0){
                            isVisited[ny][nx] = p.drill+1;
                            q.add(new Place(ny, nx, p.move+1, p.drill+1));
                        }
                    }
                }
            }
        }
    }
}


