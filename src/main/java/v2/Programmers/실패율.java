package v2.Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 실패율 {
    public static void main(String[] args) {

        int N = 5;
        int[] stages = {2,1,2,4,2,4,3,3};
        System.out.println(solution(N, stages));
    }
    /*
    * 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
    * 전체 스테이지의 갯수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages,
    * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨 있는 배열을 return 하는 것이 답
    * 
    * 스테이지의 갯수 N은 1~500까지, stages의 길이는 1~200000 
    * */

    public static int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Double> list = new HashMap<>();

        for (int stage : stages) {
            if(!map.containsKey(stage)) {
                map.put(stage, 1);
            } else {
                map.put(stage, map.get(stage) + 1);
            }
        }

        for (int i = 1; i <= N; i++) {
            // 스테이지에 속한 번호들 갯수/ 스테이지에 속한 번호 + 스테이지 이후 번호들 갯수
            int stage_n = 0;
            int next_n = 0;
            if(map.get(i) == null) {
                stage_n += 0;
            } else {
                stage_n = map.get(i);
            }

            for (int j = i; j <= N + 1; j++) {
                if(map.get(j) == null) {
                    next_n += 0;
                } else
                    next_n += map.get(j);
            }

            double result = (double) stage_n / (double) next_n;
            if(stage_n == 0 && next_n == 0) {
                list.put(i, 0.0);
                continue;
            }
            list.put(i, result);
        }

        List<Integer> keySetList = new ArrayList<>(list.keySet());
        Collections.sort(keySetList, (o1, o2) -> (list.get(o2).compareTo(list.get(o1))));

        int count = 0;
        for (Integer integer : keySetList) {
            answer[count++] = integer;
            System.out.println(integer + " " + list.get(integer));
        }
        return answer;
    }

}
