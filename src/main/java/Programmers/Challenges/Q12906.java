package Programmers.Challenges;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q12906 {

    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 0 ,1, 1};
        int[] answer = {};
        Deque<Integer> ans = new ArrayDeque<>();

        ans.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == ans.peekLast()){
                continue;
            } else {
                ans.add(arr[i]);
            }
        }

        answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.poll();
        }
    }
}
