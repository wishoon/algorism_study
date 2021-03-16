package v2.Programmers;

import java.util.*;

public class 순위_검색 {
    static Map<String, List<Integer>> wordMap = new HashMap<>();
    static int[] answer = {};

    public int[] solution(String[] info, String[] query) {

        answer = new int[query.length];

        setInfo(info);
        answerCheck(query);

        return answer;
    }

    public static void answerCheck(String[] query) {

        for (int i = 0; i < query.length; i++) {
            String str = "";
            String[] arr = query[i].split(" ");

            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j].equals("and"))
                    continue;
                str += arr[j];
            }
            answer[i] = counting(str, Integer.parseInt(arr[arr.length-1]));
        }
    }

    public static int counting(String str, int score) {
        if(wordMap.containsKey(str)==false)
            return 0;

        List<Integer> list = wordMap.get(str);
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if(list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return list.size() - start;
    }

    public static void setInfo(String[] info) {
        for (int i = 0; i < info.length; i++) {
            dfs("", 0, info[i].split(" "));
        }
        // 이후 순위 기준으로 재정렬을 해줘야 함.
        Iterator<String> it = wordMap.keySet().iterator();
        while (it.hasNext()) {
            List<Integer> li = wordMap.get(it.next());
            Collections.sort(li);
        }
    }

    public static void dfs(String str, int depth, String[] info) {
        if(depth==4) {
            // wordMap 중에서 키값이 현재 없는 경우
            if(wordMap.containsKey(str) == false) {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                wordMap.put(str, list);
            } else {
                wordMap.get(str).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(str + "-", depth + 1, info);
        dfs(str + info[depth], depth + 1, info);
    }
}