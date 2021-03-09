package v2.Programmers;

import java.util.*;

public class 메뉴_리뉴얼 {

    public static List<HashMap<String, Integer>> foodMaps = new ArrayList<>();
    public static int[] maxcnt = new int[11];

    public static void main(String[] args) {


    }
    public static void solution(String[] orders, int[] course) {

        // 조건에 10개라고 쓰여 있기 때문
        for (int i = 0; i < 11; i++) {
            foodMaps.add(new HashMap<>());
        }

        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();

        for (int len : course) {
            for (Map.Entry<String, Integer> entry : foodMaps.get(len).entrySet()) {
                if(entry.getValue() >=2 && entry.getValue() == maxcnt[len]) {
                    list.add(entry.getKey());
                }
            }
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
    }

    public static void comb(char[] str, int pos, StringBuilder candi){

        if(pos >= str.length) {
            int len = candi.length();
            if (len >= 2) {
                int cnt = foodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
                foodMaps.get(len).put(candi.toString(), cnt);
                maxcnt[len] = Math.max(maxcnt[len], cnt);
            }
            return;
        }
        comb(str, pos + 1, candi.append(str[pos]));
        candi.setLength(candi.length() - 1);
        comb(str, pos + 1, candi);
    }
}
