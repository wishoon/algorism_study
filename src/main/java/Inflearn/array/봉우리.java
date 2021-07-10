package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 봉우리 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(solution(N, arr));
    }

    public static int solution(int n, int[][] arr){
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;

                for (int k = 0; k < 4; k++) {
                    int nextY = dx[k] + i;
                    int nextX = dy[k] + j;

                    if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && arr[nextY][nextX] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag == true) {
                    count++;
                }
            }
        }
        return count;
    }
}
