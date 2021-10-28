package v3.programmers;

public class 방문_길이 {
    public static void main(String[] args) {

        String dirs = "LULLLLLLU";

        int answer = solution(dirs);
        System.out.println(answer);
    }

    // 상, 우, 하 ,좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static int solution(String dirs) {

        int answer = 0;

        boolean[][][][] visit = new boolean[11][11][11][11];

        int curX = 5, curY = 5;
        int orderN;

        for (char order : dirs.toCharArray()) {
            if (order == 'U') {
                orderN = 0;
            } else if (order == 'D') {
                orderN = 2;
            } else if (order == 'R') {
                orderN = 1;
            } else {
                orderN = 3;
            }

            int nextX = curX + dx[orderN];
            int nextY = curY + dy[orderN];

            if(nextX < 0 || nextX >= 11 || nextY < 0 || nextY >= 11) {
                continue;
            }

            if (!visit[curX][curY][nextX][nextY] && !visit[nextX][nextY][curX][curY]) {
                visit[curX][curY][nextX][nextY] = true;
                visit[nextX][nextY][curX][curY] = true;
                answer++;
            }
            curX = nextX;
            curY = nextY;
        }

        return answer;
    }
}
