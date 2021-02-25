package Programmers.Stack_Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q42584 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = {};
        Iterator<Integer> iter = null;

        answer = new int[prices.length];
        int count = 0;
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int price : prices) {
            queue.offer(price);
        }

        while (index != prices.length) {
            int temp = queue.poll();
            iter = queue.iterator();
            count = 0;
            while (iter.hasNext()) {
                int value = iter.next();
                if(temp <= value) {
                    count++;
                }
                else {
                    count++;
                    break;
                }
            }
            answer[index] = count;
            index++;
        }
    }
}
