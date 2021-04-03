package v2.Programmers;

public class 프렌즈4 {
    static boolean[][] arr;

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        solution(m, n, board);
    }

    public static void solution(int m, int n, String[] board) {
        int ans = 0;
        char[][] map = new char[m][n];
        arr = new boolean[m][n];

        for (int i  = 0; i < m; i ++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {

            int cnt = checkBoard(m, n, map);

            map = changeBoard(m, n, map);

            ans += cnt;

            if(cnt == 0) {
                break;
            }
        }
        System.out.println(ans);
    }

    public static int checkBoard(int m, int n, char[][] map){

        int count = 0;
        for (int k = 0; k < n - 1; k ++) {
            for (int i = 0; i < m - 1; i++) {
                for (int j = i + 1; j < j + 1; j++) {
                    if(map[i][k] == ' ')
                        continue;

                    System.out.println(i + " " + j + " " + k);
                    if(map[i][k] == map[i][k + 1]
                            && map[i][k] == map[j][k]
                            && map[i][k] == map[j][k + 1])
                    {
                        count++;

                        // boolean 배열 true, false 변환
                        recordBoard(k, i);
                    }
                }
            }
        }
        return count;
    }

    public static void recordBoard(int row, int col) {
        for (int i = col; i < 2; i++) {
            for (int j = row; j < 2; j++) {
                arr[j][j] = true;
            }
        }
    }

    public static char[][] changeBoard(int m, int n, char[][] map) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] = true) {
                    if(i + 1 == m) {
                        map[i][j] = ' ';
                        arr[i][j] = false;
                    } else {
                        map[i][j] = map[i + 1][j];
                        map[i + 1][j] = ' ';
                        arr[i][j] = false;
                    }
                }
            }
        }
        return map;
    }
}
