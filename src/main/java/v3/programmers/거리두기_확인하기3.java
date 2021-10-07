package v3.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 거리두기_확인하기3 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static int[] solution(String[][] places) {

        int[] answer = new int[places.length];

        for (int t = 0; t < places.length; t++) {
            boolean flag = true;
            String[] room = places[t];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(room[i].charAt(j) == 'P') {
                        if(!isCheck(i, j, room, flag)) {
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

    public static boolean isCheck(int i, int j, String[] room, boolean check) {
        // 상하좌우 검색
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        for (int c = 0; c < 4; c++) {
            // 밖으로 벗어나는 경우를 확인
            int ni = i + di[c];
            int nj = j + dj[c];

            if(ni < 0 || ni >= 5 || nj < 0 || nj >= 5) {
                continue;
            }

            if(room[ni].charAt(nj) == 'P') {
                return false;
            }
        }

        // 상하좌우가 맨하튼 거리 2인 경우
        int[] di2 = {2, -2, 0, 0};
        int[] dj2 = {0, 0, 2, -2};

        for (int c = 0; c < 4; c++) {
            // 밖으로 벗어나는 경우를 확인
            int ni = i + di[c];
            int nj = j + dj[c];

            if(ni < 0 || ni >= 5 || nj < 0 || nj >= 5) {
                continue;
            }

            if(room[ni].charAt(nj) == 'P') {
                if(!(room[(ni + i) / 2].charAt((nj + j) / 2) == 'X')) {
                    return false;
                }
            }
        }

        // 대각선 검색
        int[] di3 = {1, 1, -1, -1};
        int[] dj3 = {1, -1, 1, -1};

        for (int c = 0; c < 4; c++) {
            // 밖으로 벗어나는 경우를 확인
            int ni = i + di[c];
            int nj = j + dj[c];

            if(ni < 0 || ni >= 5 || nj < 0 || nj >= 5) {
                continue;
            }
            if(room[ni].charAt(nj) == 'P') {
                if(!(room[ni].charAt(j) == 'X' && room[i].charAt(nj) == 'X')) {
                    return false;
                }
            }
        }

        return true;
    }
}
