package v2.Programmers;
import java.util.*;

public class 동굴_탐험 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] before;
    static int[] after;

    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        boolean[] visit = new boolean[n];
        before = new int[n];
        after = new int[n];
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < path.length; i++) {
            int start = path[i][0];
            int end = path[i][1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(int i = 0; i < order.length; i++) {
            before[order[i][1]] = order[i][0];
        }

        if(before[0] != 0) {
            return false;
        }

        visit[0] = true;


        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < graph.get(0).size(); i++) {
            st.push(graph.get(0).get(i));
        }

        while(!st.isEmpty()) {
            int now = st.pop();

            if(visit[now])
                continue;

            if(!visit[before[now]]) {
                after[before[now]] = now;
                continue;
            }

            visit[now] = true;
            for(int i = 0; i < graph.get(now).size(); i++) {
                st.push(graph.get(now).get(i));
            }

            st.push(after[now]);
        }

        for(int i = 0; i < n; i++) {
            if(!visit[i])
                return false;
        }
        return true;
    }
}
