package v3.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 친구인가 {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int fa = find(a);
        int fb = find(b);

        if(fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa != fb) {
            arr[fa] = fb;
        }
    }

    public static int find(int n) {
        if(n == arr[n])
            return arr[n];

        else
            return arr[n] = find(arr[n]);
    }
}
