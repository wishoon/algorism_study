package Programmers.Challenges;

import java.util.*;

public class Q68644 {

    // 아마 조합으로 풀면 쉽게 풀린다.

    public static void main(String[] args) {
        int[] numbers = {5, 0, 2, 7};
        int[] answers = {};
        int count = 0;
        Set<Integer> arr = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            int temp = i;
            for (int j = 0; j < numbers.length; j++) {
                if(temp == j)
                    continue;
                int num = numbers[i] + numbers[j];
                arr.add(num);
            }
        }
        answers = new int[arr.size()];
        Iterator<Integer> answer = arr.iterator();

        for (Iterator<Integer> it = answer; it.hasNext(); ) {
            int n = it.next();
            answers[count] = n;
            count++;
        }

        Arrays.sort(answers);
    }
}
