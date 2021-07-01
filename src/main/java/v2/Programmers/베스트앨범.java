package v2.Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 베스트앨범 {

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = {};
            ArrayList<Integer> answer_list = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();

            for(int i = 0; i < genres.length; i++) {
                if(map.containsKey(genres[i])) {
                    map.put(genres[i], map.get(genres[i]) + plays[i]);
                } else {
                    map.put(genres[i], plays[i]);
                }
            }

            List<String> keySetList = new ArrayList<>(map.keySet());
            Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

            for(String key : keySetList) {
                HashMap<Integer, Integer> key_map = new HashMap<Integer, Integer>();
                for(int i = 0; i < genres.length; i++) {
                    if(key.equals(genres[i])) {
                        key_map.put(i, plays[i]);
                    }
                }
                List<Integer> keyLists = new ArrayList<>(key_map.keySet());
                // System.out.println(keyLists.size());
                Collections.sort(keyLists, (s1, s2) -> (key_map.get(s2).compareTo(key_map.get(s1))));

                int count = 0;
                for(Integer c : keyLists) {
                    if(count > 1)
                        break;
                    answer_list.add(c);
                    count++;
                }
            }
            answer = new int[answer_list.size()];

            for(int i = 0; i < answer_list.size(); i++) {
                answer[i] = answer_list.get(i);
            }
            return answer;
        }
    }
}
