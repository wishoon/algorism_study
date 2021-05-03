package v2.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 가장_큰_수 {

    class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            String[] str = new String[numbers.length];

            // int 배열 String 배열로 변환
            for(int i = 0; i < numbers.length; i++) {
                str[i] = String.valueOf(numbers[i]);
            }

            // a + b 와 b + a를 비교
            Arrays.sort(str, (o1, o2) -> ((o2 + o1)).compareTo(o1 + o2));

            if(str[0].equals("0")) {
                return "0";
            }

            for(String s : str) {
                answer += s;
            }

            return answer;
        }
    }
}
