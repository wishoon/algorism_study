package Programmers.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class Q42746 {
    public static void main(String[] args) {

    }

    class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            String[] sarr = new String[numbers.length];
            for (int i = 0; i < sarr.length; i++) {
                sarr[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(sarr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.equals("0") && o2.equals("0"))
                        return 0;
                    return (o2 + o1).compareTo(o1 + o2);
                }
            });
            if(sarr[0].equals("0"))
                return "0";

            for (int i = 0; i < sarr.length; i++) {
                answer += sarr[i];
            }
            return answer;
        }
    }
}
