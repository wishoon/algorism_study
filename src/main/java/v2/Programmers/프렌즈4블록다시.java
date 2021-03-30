package v2.Programmers;

public class 프렌즈4블록다시 {


    public static void main(String[] args) {

        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        System.out.println(solution(m, n, board));

    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {

            int cnt = checkBoard(m, n, map);

            if(cnt == 0) {
                break;
            }

            answer += cnt;
            dropBoard(m, n, map);
        }

        return answer;
    }

    private static int checkBoard(int m, int n, char[][] map) {
        int cnt = 0;

        boolean[][] isChecked = new boolean[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(map[i][j] == '.') continue;

                checkSquare(i, j, map, isChecked);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isChecked[i][j]) {
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }
        return cnt;
    }


    public static void checkSquare(int i, int j, char[][] map, boolean[][] isCheck) {
        char block = map[i][j];

        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                if(map[r][c] != block)
                    return;
            }
        }

        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                isCheck[r][c] = true;
            }
        }

    }

    private static void dropBoard(int m, int n, char[][] map) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("==========");
        for (int c = 0; c < n; c++) {
            for (int r = m - 1; r >= 0; r--) {
                if(map[r][c] == '.') {
                    for (int dr = r - 1; dr >= 0 ; dr--) {

                        // 밑에서 부터 체크해서 위에 '.'이 없는 경우 자리를 교환하는 시스템...
                        if(map[dr][c] != '.') {
                            map[r][c] = map[dr][c];
                            map[dr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("==========");
    }
}
