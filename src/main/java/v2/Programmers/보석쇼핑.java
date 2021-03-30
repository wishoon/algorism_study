package v2.Programmers;

import java.util.HashMap;
import java.util.HashSet;

public class 보석쇼핑 {
    public static void main(String[] args) {

    }

    public int[] solution(String[] gems) {

        int[] answer = new int[2];

        int start = 0;
        int end = 0;

        int left = 0, right = 0;
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (String gem : gems) {
            set.add(gem);
        }

        while (true) {

            if(set.size() == map.size()) {

            } else if(right == gems.length) {
                break;
            } else {
                // right 오른쪽으로 이동
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
        }




        return answer;
    }

    /*
    * 1. 투 포인터 알고리즘을 사용하여 검색을 실행한다.
    * 2. 만약 찾을 경우 해당 원소들을 계속 포함하는지 확인하면서 진행한다.*/
}
