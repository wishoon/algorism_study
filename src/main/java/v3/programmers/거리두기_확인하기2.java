package v3.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 거리두기_확인하기2 {
    /*
    *   물론 이 방법도 괜찮은데 bfs로 푸는게 더 좋았을 듯 하다.
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int t = 0; t < places.length; t++) {
            String[] map = places[t];
            boolean flag = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(map[i].charAt(j) == 'P') {
                        // 주변 사람 탐색
                        if(!checkPerson(i, j, map)) {
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

    public static boolean checkPerson(int i, int j, String[] map) {

        // 상하좌우 검색
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        for (int t = 0; t < 4; t++) {
            int mi = i + di[t];
            int mj = j + dj[t];

            if(mi < 0 || mi >=5 || mj < 0 || mj >= 5) {
                continue;
            }
            if(map[mi].charAt(mj) == 'P')
                return false;
        }

        // 상하좌우 맨하탄 거리 2
        int[] di2 = {0, 0, 2, -2};
        int[] dj2 = {2, -2, 0, 0};
        for (int t = 0; t < 4; t++) {
            int mi = i + di2[t];
            int mj = j + dj2[t];

            if(mi < 0 || mi >=5 || mj < 0 || mj >= 5) {
                continue;
            }
            if(map[mi].charAt(mj) == 'P') {
                // 만약 가는길에 벽이 없을
                // 현재 P - P를 바라보는 상태에서 이를 체크하기 때문에 문제가 없다.
                if(map[(i + mi) / 2].charAt((j + mj) / 2) != 'X') {
                    return false;
                }
            }
        }

        // 대각선 확인
        int[] di3 = {1, 1, -1, -1};
        int[] dj3 = {1, -1, 1, -1};

        for (int t = 0; t < 4; t++) {
            int mi = i + di3[t];
            int mj = j + dj3[t];

            if(mi < 0 || mi >=5 || mj < 0 || mj >= 5) {
                continue;
            }
            if(map[mi].charAt(mj) == 'P') {
                if(!(map[i].charAt(mj) == 'X' && map[mi].charAt(j) == 'X')) {
                    return false;
                }
            }
        }

        return true;
    }
}
