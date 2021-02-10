package BackJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11054 {

    static int arr[];
    static Integer lis[];
    static Integer lds[];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        lis = new Integer[N];
        lds = new Integer[N];

        String input[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < N; i++) {
            lis(i);
            lds(i);
        }
        for (int i = 0; i < N; i++) {
            max = Math.max(lis[i] + lds[i], max);
        }
        System.out.println(max - 1);
    }

    public static int lis(int n){
        if(lis[n] == null){
            lis[n] = 1;

            for (int i = n - 1; i >= 0 ; i--) {
                if(arr[i] < arr[n]){
                    lis[n] = Math.max(lis[n], lis(i) + 1);
                }
            }
        }
        return lis[n];
    }

    public static int lds(int n){
        if(lds[n] == null){
            lds[n] = 1;

            for (int i = n + 1; i < lds.length; i++) {
                if(arr[i] < arr[n]){
                    lds[n]= Math.max(lds[n], lds(i) + 1);
                }
            }
        }
        return lds[n];
    }

}
