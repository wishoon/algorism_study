package v3.programmers;

import java.util.HashSet;

public class 영어_끝말잇기 {
    public static void main(String[] args) {

        int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

        int[] answer = solution(n, words);

        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] solution(int n, String[] words) {

        int[] answer = {0, 0};
        HashSet<String> user_words = new HashSet<>();

        char last_alpha = words[0].charAt(0);
        int human_idx = 1;
        int turn = 1;

        for (int i = 0; i < words.length; i++) {

            if (last_alpha != words[i].charAt(0)) {
                answer[0] = human_idx;
                answer[1] = turn;
                return answer;
            }

            last_alpha = words[i].charAt(words[i].length() - 1);

            if (user_words.contains(words[i])) {
                answer[0] = human_idx;
                answer[1] = turn;
                return answer;
            }

            user_words.add(words[i]);
            human_idx++;

            if (human_idx == n + 1) {
                human_idx = 1;
                turn++;
            }
        }

        return answer;
    }
}
