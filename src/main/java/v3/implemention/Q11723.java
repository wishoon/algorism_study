package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> numSet = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if (order.equals("add")) {
                numSet.add(Integer.parseInt(st.nextToken()));
            } else if (order.equals("remove")) {
                numSet.remove(Integer.parseInt(st.nextToken()));
            } else if (order.equals("check")) {
                if (numSet.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (order.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (numSet.contains(num)) {
                    numSet.remove(num);
                } else {
                    numSet.add(num);
                }
            } else if (order.equals("all")) {
                numSet.clear();
                for (int j = 1; j <= 20; j++) {
                    numSet.add(j);
                }
            } else if (order.equals("empty")) {
                numSet.clear();
            }
        }

        System.out.print(sb);
    }
}
