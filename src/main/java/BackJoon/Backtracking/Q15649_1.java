package BackJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15649_1 {

    public static boolean[] visited;// = new boolean[N];
    public static int[] arr; //= new int[M];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        visited = new boolean[N];
        arr = new int[M];

        dfs(N, M, 0);
    }

    public static void dfs(int N, int M, int depth){
        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if(depth == M){
            for(int val : arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            // 만약 해당 노드를 방문하지 않았다면
            if(visited[i] == false){
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visited[i] = false;
            }
        }
    }
}
