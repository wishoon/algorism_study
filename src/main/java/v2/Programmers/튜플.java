package v2.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 튜플 {
    public static void main(String[] args) {

        String s = "{{20,111},{111},{30,111,20}}";
        solution(s);
    }

    /*
        중복된 원소가 있을 수 있다.
        원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플
        튜플의 원소 갯수는 유한
        --
        원소의 갯수가 n개이고, 중복되는 원소가 없는 튜플 -> {{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}

     */
    public static int[] solution(String s) {

        String tran_s = s.substring(1, s.length() - 2);
        String[] index = tran_s.split("},");

        for (int i = 0; i < index.length; i++) {
            index[i] = index[i].substring(1);
        }

        Arrays.sort(index, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        ArrayList<String> answerList = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            String[] str = index[i].split(",");

            for (int j = 0; j < str.length; j++) {
                if (!answerList.contains(str[j])) {
                    answerList.add(str[j]);
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = Integer.parseInt(answerList.get(i));
        }

        return answer;
    }
}
