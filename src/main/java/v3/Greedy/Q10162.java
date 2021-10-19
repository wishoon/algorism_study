package v3.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int a = 0, b = 0, c = 0;
        int[] time = {300, 60, 10};


        if(t / time[0] > 0) {
            a += t / time[0];
            t %= time[0];
        }

        if(t / time[1] > 0) {
            b += t / time[1];
            t %= time[1];
        }

        if(t / time[2] > 0) {
            c += t / time[2];
            t %= time[2];
        }

        if(t != 0) {
            System.out.println(-1);
        } else {
            System.out.println(a + " " + b + " " + c);
        }
    }
}
