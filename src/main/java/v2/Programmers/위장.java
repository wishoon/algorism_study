package v2.Programmers;

import java.util.HashMap;

public class 위장 {

    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            // 옷의 종류 별로 몇개씩 있는지..
            HashMap<String, Integer> map = new HashMap<>();

            for(int i = 0; i < clothes.length; i++) {
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
            }

            for(String keys: map.keySet()) {
                answer *= (map.get(keys) + 1);
            }

            answer -= 1;
            return answer;
        }
    }
}
