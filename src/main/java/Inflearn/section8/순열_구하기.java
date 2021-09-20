package Inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 해당 숫자, 순열 갯수
        int n = 0, s = 0;

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] arr= new int[n];
        int[] visit = new int[n];
        int[] data = new int[s];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr, visit, data, 0, s);
    }

    public static void dfs(int[] arr, int[] visit, int[] data, int depth, int limit) {

        if(depth == limit) {
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if(visit[i] == 0) {
                    visit[i] = 1;
                    data[depth] = arr[i];
                    dfs(arr, visit, data,depth + 1, limit);
                    visit[i] = 0;
                }
            }
        }
    }
}
