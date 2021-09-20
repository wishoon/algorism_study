package Inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합이_같은_부분집합_DFS {
    /*
    N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
    두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
    둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
    예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.

    첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.

    두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
     */
    static int total = 0;
    static String answer = "NO";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        solution(n, arr);
        System.out.println(answer);
    }

    public static void solution(int n, int[] arr) {
        dfs(0, 0, arr);
    }

    public static void dfs(int depth, int sum, int[] arr) {
        boolean flag = false;
        if(flag) {
            return;
        }
        if(depth == arr.length) {
            if(total - sum == sum) {
                flag = true;
                answer = "YES";
            }
        } else {
            dfs(depth + 1, sum + arr[depth], arr);
            dfs(depth + 1, sum, arr);
        }
    }
}
