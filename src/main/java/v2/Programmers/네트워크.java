package v2.Programmers;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[computers.length];

        for(int i = 0; i < computers.length; i++) {
            if(!check[i]) {
                dfs(i, computers, check);
                answer++;
            }
        }

        return answer;
    }

    static boolean[] dfs(int idx, int[][] computers, boolean[] check) {
        check[idx] = true;

        for(int i = 0; i < computers.length; i++) {
            if(i != idx && check[i] == false && computers[idx][i] == 1) {
                dfs(i, computers, check);
            }
        }

        return check;
    }
}
