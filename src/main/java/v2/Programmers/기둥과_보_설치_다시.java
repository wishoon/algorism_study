package v2.Programmers;

public class 기둥과_보_설치_다시 {
    static boolean[][] pillar;  // 기둥
    static boolean[][] bar;     // 보

    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n + 2][n + 2];
        bar = new boolean[n + 2][n + 2];

        int count = 0;

        for (int[] build : build_frame) {
            int x = build[0], y = build[1];
            int type = build[2], cmd = build[3];

            if(type == 0) {
                if(cmd == 1) {
                    if(checkPillar(x, y)) {
                        pillar[x][y] = true;
                        count++;
                    }
                } else {
                    pillar[x][y] = false;
                    if(canDelete(x, y) == false) {
                        pillar[x][y] = true;
                    } else {
                        count--;
                    }
                }
            } else {
                if(cmd == 1) {
                    if(checkBar(x, y)) {
                        bar[x][y] = true;
                        count++;
                    }
                } else {
                    bar[x][y] = false;
                    if(canDelete(x, y) == false) {
                        bar[x][y] = true;
                    } else
                        count--;
                }
            }
        }

        int[][] answer = new int[count][3];
        count = 0;

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if(pillar[x][y]) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count][2] = 0;
                    count++;
                }
                if(bar[x][y]) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count][2] = 1;
                    count++;
                }
            }
        }
        return answer;
    }

    private boolean canDelete(int x, int y) {
        for (int i = Math.max(0, x - 1); i <= x + 1 ; i++) {
            for (int j = y; j <= y + 1 ; j++) {
                if (pillar[i][j] && checkPillar(i, j) == false) {
                    return false;
                }

                if (bar[i][j] && checkBar(i, j) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBar(int x, int y) {
        if(pillar[x][y - 1] || pillar[x + 1][y - 1] || (x > 0 && bar[x - 1][y] && bar[x + 1][y]))
            return true;

        return false;
    }

    private boolean checkPillar(int x, int y) {
        if(y == 0 || pillar[x][y - 1] || (x > 0 && bar[x - 1][y]) || bar[x][y]) {
            return true;
        }
        return false;
    }
}
