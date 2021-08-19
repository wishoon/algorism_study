package Inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정_설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String essential = br.readLine();
        String choice = br.readLine();

        Queue<Character> queue = new LinkedList<>();
        for (char c : essential.toCharArray()) {
            queue.add(c);
        }

        for (int i = 0; i < choice.length(); i++) {
            if(queue.isEmpty()) {
                System.out.println("YES");
                return;
            }
            if(queue.peek() == choice.charAt(i)) {
                queue.poll();
            }
        }

        if(queue.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
