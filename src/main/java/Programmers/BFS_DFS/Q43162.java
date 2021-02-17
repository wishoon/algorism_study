package Programmers.BFS_DFS;

public class Q43162 {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        int answer = 0;
        boolean[] visited = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int[][] computers, int i, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if(i != j && computers[i][j] == 1 && visited[j] == false) {
                dfs(computers, j, visited);
            }
        }
    }
}
