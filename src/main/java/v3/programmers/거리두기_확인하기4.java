package v3.programmers;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 거리두기_확인하기4 {
    public static void main(String[] args) {

    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int t = 0; t < places.length; t++) {
            boolean flag = true;
            String[] room = places[t];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(room[i].charAt(j) == 'P') {
                        if(!bfs(i, j, room)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if(!flag) {
                    answer[t] = 0;
                    break;
                }
            }
            if(flag) {
                answer[t] = 1;
            }
        }

        return answer;
    }

    public static boolean bfs(int i, int j, String[] room) {
        int[] di = {-1, 1, 0 ,0};
        int[] dj = {0, 0, -1, 1};

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for (int c = 0; c < 4; c++) {
                int nr = di[c] + node.x;
                int nc = dj[c] + node.y;

                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || (i == nr && j == nc)) {
                    continue;
                }

                int md = Math.abs(i - nr) + Math.abs(j - nc);

                // 다음 방의 공간이 P이면서
                if(room[nr].charAt(nc) == 'P' && md <= 2) {
                    return false;
                } else if(room[nr].charAt(nc) == 'O' && md < 2) {
                    queue.offer(new Node(nr, nc));
                }
            }
        }
        return true;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
