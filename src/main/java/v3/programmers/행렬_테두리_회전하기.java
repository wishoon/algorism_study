package v3.programmers;

public class 행렬_테두리_회전하기 {
    public static void main(String[] args) {

        int rows = 100;
        int columns = 97;
//        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
        int[][] queries = {{1,1,100,97}};

        int answer[] = solution(rows, columns, queries);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = (i * columns + j + 1);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(arr, queries[i]);
        }


        return answer;
    }

    public static int rotate(int[][] arr, int[] query) {

        // 문제에서는 1,1 부터 측정함. 이로 인해 실제 저장된 값에 맞추기 위해 -1 수행
        int r1 = query[0] - 1;
        int c1 = query[1] - 1;
        int r2 = query[2] - 1;
        int c2 = query[3] - 1;

        int min = arr[r1][c1];
        int temp = arr[r1][c1];

        // 좌측 부분
        for (int r = r1; r < r2; r++) {
            arr[r][c1] = arr[r + 1][c1];
            min = Math.min(min, arr[r][c1]);
        }
        // 하단 부분
        for (int c = c1; c < c2; c++) {
            arr[r2][c] = arr[r2][c + 1];
            min = Math.min(min, arr[r2][c]);
        }
        // 우측 부분
        for (int r = r2; r > r1; r--) {
            arr[r][c2] = arr[r - 1][c2];
            min = Math.min(min, arr[r][c2]);
        }
        // 상단 부분 (5, 4)
        for (int c = c2; c > c1; c--) {
            arr[r1][c] = arr[r1][c - 1];
            min = Math.min(min, arr[r1][c]);
        }
        arr[r1][c1 + 1] = temp;

        return min;
    }

}
