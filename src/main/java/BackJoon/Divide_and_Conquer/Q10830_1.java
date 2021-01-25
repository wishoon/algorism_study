package BackJoon.Divide_and_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10830_1 {

    static int N;
    static int[][] arr;
//    static int[][] result1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        long M = Long.parseLong(input[1]);

        arr = new int[N][N];
//        result1 = new int[N][N];

        String[] str;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        int[][] result1 = sqr(M);
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(result1[i][j] % 1000 + " ");
            }
            System.out.println();
        }
    }

    public static int[][] sqr(long m){
        int[][] temp = new int[N][N];
        int[][] result = new int[N][N];
        if(m == 1) {
            return arr;
        }

        if(m % 2 == 0){
            temp = sqr(m/2);
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    for(int l=0;l<N;l++) {
                        result[i][j]+=temp[i][l]*temp[l][j];
                    }
                    result[i][j]%=1000;
                }
            }
            return result;
        } else {
            temp = sqr(m-1);
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    for(int l=0;l<N;l++) {
                        result[i][j]+=temp[i][l]*arr[l][j];
                    }
                    result[i][j]%=1000;
                }
            }
            return result;
        }
    }
}
