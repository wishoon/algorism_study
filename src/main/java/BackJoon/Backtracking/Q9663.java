package BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {

    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth){
        // 모든 원소를 다 채운 상태면 count 증가 및 depth
        if(depth == N){
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            // 놓을 수 있는 경우 재귀 호출
            if(possibility(depth))
                nQueen(depth + 1);
        }
    }

    public static boolean possibility(int col){

        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할 경우
            if (arr[col] == arr[i])
                return false;

            // 대각선상에 놓여 있는 경우 -> 열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }
        return true;
    }
}
