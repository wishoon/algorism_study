package BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
    public static int N;
    public static int[][] map;
    public static boolean[] visit;
    public static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(MIN);
    }

    public static void dfs(int idx, int depth) {
        if(depth == N/2){
            diff();
            return;
        }

        for(int i=idx; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // i번째 사람과 j번째 사람이 TRUE 일 경우
                if (visit[i] == true && visit[j] == true) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }
        // 두 팀의 점수 차이 계산
        int min = Math.abs(team_start - team_link);

        if(min == 0){
            System.out.println(0);
            System.exit(0);
        }
        MIN = Math.min(min, MIN);
    }
}
