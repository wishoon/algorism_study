package v3.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Q5430 {

    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayDeque<Integer> deque;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");

            deque = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            commandCheck(command, deque);
        }
        System.out.println(sb);
    }

    public static void commandCheck(String command, ArrayDeque<Integer> deque) {
        boolean isFront = true;

        for (char cmd : command.toCharArray()) {
            if(cmd == 'R') {
                isFront = !isFront;
                continue;
            }

            if(isFront) {
                if(deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if(deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        makePrintString(deque, isFront);
    }

    public static void makePrintString(ArrayDeque<Integer> deque, boolean isFront) {

        sb.append('[');

        if(deque.size() > 0) {
            if(isFront) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');
    }
}
