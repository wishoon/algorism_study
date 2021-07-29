package BackJoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {

    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(recur(N) + "\n");
        }
        System.out.println(sb);
    }

    public static int recur(int N) {

        if(N == 1) {
            return 1;
        }
        if(N == 2) {
            return 2;
        }
        if(N == 3) {
            return 4;
        }

        return recur(N - 1) + recur(N - 2) + recur(N - 3);
    }
}
