package BackJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int N = 0;
        int M = 0;

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        int sum = 0;
        int temp = 0;
        String value[] = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(value[i]);
        }

        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    temp = arr[i] + arr[j] + arr[k];
                    System.out.println(temp);
                    if(temp <= M && temp > sum){
                        sum = temp;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
