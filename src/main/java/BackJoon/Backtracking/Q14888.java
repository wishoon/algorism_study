package BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14888 {

    public static int N;
    public static int[] number;
    public static int[] operator = new int[4];
    public static int min = 0;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        number = new int[N];
        String input[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(input[i]);
        }
        String input1[] = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(input1[i]);
        }

        backTracking(N, 0, 0);
    }

    public static boolean backTracking(int N, int x, int y){
        for (int i = 0; i < N; i++) {

            if(y == x - 1){

            }
            backTracking(N, x, y + 1);
        }
        return true;
    }
}
