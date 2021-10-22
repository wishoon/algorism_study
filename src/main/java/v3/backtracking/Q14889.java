package v3.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14889 {

    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] team = new boolean[n];
        backtracking(team, 0,0);

        System.out.println(min);
    }

    public static void backtracking(boolean[] team, int start, int depth) {
        if (depth == n / 2) {
            calculate(team);
            return;
        }

        for (int i = start; i < n; i++) {
            if(team[i] == false) {
                team[i] = true;
                backtracking(team, i + 1, depth + 1);
                team[i] = false;
            }
        }
    }

    public static void calculate(boolean[] team) {
        int team1_sum = 0;
        int team2_sum = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(team[i] == true && team[j] == true) {
                    team1_sum += arr[i][j];
                    team1_sum += arr[j][i];
                } else if (team[i] == false && team[j] == false) {
                    team2_sum += arr[i][j];
                    team2_sum += arr[j][i];
                }
            }
        }

        int val = Math.abs(team1_sum - team2_sum);

        if(val == 0) {
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min, val);
    }
    public static void calculate1(boolean[] team) {
        int temp_min = 0;
        int team1_sum = 0;
        int team2_sum = 0;
        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();

        for (int i = 0; i < team.length; i++) {
            if(team[i] == false) {
                team1.add(i);
            } else {
                team2.add(i);
            }
        }

        for (int i = 0; i < team.length / 2; i++) {
            for (int j = i; j < team.length / 2; j++) {
                if (i == j)
                    continue;

                int x1 = team1.get(i);
                int y1 = team1.get(j);
                team1_sum += arr[x1][y1] + arr[y1][x1];

                int x2 = team2.get(i);
                int y2 = team2.get(j);
                team2_sum += arr[x2][y2] + arr[y2][x2];
            }
        }

        temp_min = Math.abs(team1_sum - team2_sum);
        min = Math.min(min, temp_min);
    }
}
