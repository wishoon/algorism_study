package v3.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 로또의_최고순위와_최저순위 {
    public static void main(String[] args) {

        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};

        int[] answer = solution(lottos, win_nums);

        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {

        int[] rank = {6, 6, 5, 4, 3, 2, 1};

        List<Integer> lotto_list = new ArrayList<>();
        List<Integer> win_list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            lotto_list.add(lottos[i]);
            win_list.add(win_nums[i]);
        }

        Collections.sort(lotto_list, Collections.reverseOrder());
        Collections.sort(win_list, Collections.reverseOrder());

        int minCnt = 0;
        int maxCnt = 0;
        for (int i = 0; i < lotto_list.size(); i++) {
            for (int j = 0; j < win_list.size(); j++) {
                if(lotto_list.get(i) == win_list.get(j)) {
                    lotto_list.remove(i);
                    win_list.remove(i);
                    minCnt++;
                    i--;
                    break;
                }
            }
        }

        for (Integer integer : lotto_list) {
            if(integer == 0) {
                maxCnt++;
            }
        }
        maxCnt += minCnt;


        // 가능한 최고 순위와 최저 순위를 구하라
        int[] answer = {rank[maxCnt], rank[minCnt]};
        return answer;
    }
    /**
     * 44, 31, 25, 1, 0, 0
     * 45, 31, 19, 10, 6, 1
     * 먼저 내림차순으로 정렬을 한 후
     *
     * 동일한 숫자를 제거
     * 44, 25, 0, 0
     * 45, 19, 10, 6
     *
     * 동일한 숫자가 재거 된 숫자가 최저 당첨 숫자
     * 남아있는 0의 갯수 + 최저 숫자가 최고 당첨 숫자
     * ======================
     *
     * 45, 35, 20, 9, 4, 3
     * 45, 35, 20, 9, 4, 3
     * 먼저 내림차순으로 정렬은 한 후
     *
     * 동일한 숫자를 제거
     *
     */
}
