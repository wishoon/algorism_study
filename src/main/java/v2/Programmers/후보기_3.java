package v2.Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 후보기_3 {

    static ArrayList<HashSet<Integer>> candidate;
    static int answer = 0;

    public static void main(String[] args) {

        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        solution(relation);

        System.out.println(answer);
    }

    public static void solution(String[][] relation) {
        candidate = new ArrayList<>();

        int colsize = relation[0].length;

        HashSet<Integer> keys = new HashSet<>();

        // 1개 ~ n개까지의 조합을 뽑아내기
        for (int n = 1; n <= colsize; n++) {
            combination(0, 0, n, colsize, keys, relation);
        }
    }

    public static void combination(int idx, int start, int end, int colsize, HashSet<Integer> keys, String[][] relation) {
        if(idx == end) {
            // 지금 조회할 값이 최소성을 위반하는지 확인
            for (HashSet<Integer> key : candidate) {
                if(keys.containsAll(key))
                    return;
            }

            // 유일성 확인
            int count = 0;
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int keyidx : keys) {
                    sb.append(relation[i][keyidx]);
                }
                // 동일한 키가 있을 경우 중단
                if(map.containsKey(sb.toString()))
                    return;
                map.put(sb.toString(), sb.toString());

                count++;
            }

            // 만약 끝까지 다 조회를 한 경우 후보키 리스트에 추가
            if(count == relation.length){
                candidate.add(keys);
                answer++;
            }

            return;
        }

        for (int i = start; i < colsize; i++) {
            HashSet<Integer> candidate = new HashSet<>(keys);
            candidate.add(i);
            combination(idx + 1, start + 1, end, colsize, candidate, relation);
        }
    }
}
