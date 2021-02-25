package BackJoon.Bfs_DfS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {

    static int T;
    static int S;   // 체스판의 한 변의 길이
    static int[][] cur;   // 나이트가 현재 있는 칸
    static int[][] move;  // 나이트가 이동하려고 하는 칸
    static int[][] visit;
    static int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T =  Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            cur = new int[1][2];
            move = new int[1][2];
            visit = new int[S][S];

            st = new StringTokenizer(br.readLine(), " ");
            cur[0][0] = Integer.parseInt(st.nextToken());
            cur[0][1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            move[0][0] = Integer.parseInt(st.nextToken());
            move[0][1] = Integer.parseInt(st.nextToken());

            bfs();
            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(cur[0][0], cur[0][1]));
        visit[cur[0][1]][cur[0][0]] = 0;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.y == move[0][1] && temp.x == move[0][0]){
                ans = visit[temp.y][temp.x];
                break;
            }
            for (int i = 0; i < 8; i++) {
                int curx = temp.x + dx[i];
                int cury = temp.y + dy[i];

                if(curx < 0 || cury < 0 || curx >= S || cury >= S)
                    continue;

                if(visit[cury][curx] == 0) {
                    queue.offer(new Node(curx, cury));
                    visit[cury][curx] = visit[temp.y][temp.x] + 1;
                }
            }
        }
    }

    static class Node {
        private int x;
        private int y;
//        private int cnt;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
