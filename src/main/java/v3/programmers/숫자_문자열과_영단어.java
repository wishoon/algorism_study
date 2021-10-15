package v3.programmers;

import java.util.HashMap;

public class 숫자_문자열과_영단어 {
    public static void main(String[] args) {

        String s = "23four5six7";

        solution(s);
    }
    public static int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder sb = new StringBuilder();
        StringBuilder alpha = new StringBuilder();

        for (char c : s.toCharArray()) {
            if(c - '0' >= 0 && c - '0' <= 9) {
                sb.append(c);
            } else {
                alpha.append(c);
                if(map.containsKey(alpha.toString())) {
                    sb.append(map.get(alpha.toString()));
                    alpha = new StringBuilder();
                }
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static int solution2(String s) {

        String[] alpha = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] number = {"0","1","2","3","4","5","6","7","8","9"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(alpha[i], number[i]);
        }

        return Integer.parseInt(s);
    }
}
