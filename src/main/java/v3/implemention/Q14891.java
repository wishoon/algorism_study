package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14891 {

    static int[] point = {0, 1, 2, 4, 8};
    static String[] wheel;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        wheel = new String[5];

        for (int i = 1; i <= 4; i++) {
            wheel[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
//            rotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), true, true);
            rotate2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int i = 1; i <= 4; i++) {
            if (wheel[i].charAt(0) == '1') {
                answer += point[i];
            }
        }

        System.out.println(answer);
    }
    private static void rotate2(int cur_idx, int dir) {

        int[] check = new int[5];
        check[cur_idx] = dir;

        int stand_dir = dir;
        int stand_idx = cur_idx;

        boolean left_flag = true;
        int left_idx = cur_idx;

        while (left_flag) {
            left_idx -= 1;

            if (left_idx >= 1 && wheel[left_idx].charAt(2) != wheel[stand_idx].charAt(6)) {
                check[left_idx] = -stand_dir;

                stand_idx = left_idx;
                stand_dir = -stand_dir;
            } else {
                left_flag = false;
            }
        }

        stand_dir = dir;
        stand_idx = cur_idx;

        boolean right_flag = true;
        int right_idx = cur_idx;

        while (right_flag) {
            right_idx += 1;

            if (right_idx <= 4 && wheel[right_idx].charAt(6) != wheel[stand_idx].charAt(2)) {
                check[right_idx] = -stand_dir;

                stand_idx = right_idx;
                stand_dir = -stand_dir;
            } else {
                right_flag = false;
            }
        }

        for (int i = 1; i <= 4; i++) {
            wheel[i] = change(wheel[i], check[i]);
        }
    }

    private static void rotate(int cur_idx, int dir, boolean left, boolean right) {
        int left_idx = cur_idx - 1;
        int right_idx = cur_idx + 1;


        if (left && left_idx >= 1 && wheel[cur_idx].charAt(6) != wheel[left_idx].charAt(2)) {
            rotate(left_idx, -dir, true, false);
        }
        // 오른쪽 이면서 오른쪽 숫자가 4를 넘지 않으면서 현재 톱니바퀴와 오른쪽 톱니바퀴가 같은 자석의 모양인 경우
        if (right && right_idx <= 4 && wheel[cur_idx].charAt(2) != wheel[right_idx].charAt(6)) {
            rotate(right_idx, -dir, false, true);
        }

        wheel[cur_idx] = change(wheel[cur_idx], dir);
    }

    public static String change(String state, int dir) {
        if (dir == 0) {
            return state;
        }
        if (dir == 1) {
            return state.charAt(state.length() - 1) + state.substring(0, state.length() - 1);
        } else {
            return state.substring(1) + state.charAt(0);
        }
    }
}
