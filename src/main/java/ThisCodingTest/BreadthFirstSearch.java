package ThisCodingTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    /*BFS는 큐 자료구조를 이용하며, 다음과 같이 실행된다.
        1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
        2. 큐에서 노드를 꺼낸 뒤에 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리한다.
        3. 더 이상 2번의 과정을 수행할 수 없을 때가지 반복한다.*/
    // 특정 조건에서의 최단 경로를 구하는 문제 유형이 나오기도 한다.

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // BFS 함수 정의
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // 현재 노드를 방문 처리
        visited[start] = true;
        // 큐가 빌 때까지 반복
        while(!q.isEmpty()){
            // 큐에서 하나의 원소를 뽑아 출력
            int x = q.poll();
            System.out.println(x + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if(!visited[y]){
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }


    }
}
