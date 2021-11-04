package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15686_2 {

    static int N, M;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Node> house = new ArrayList<>();
        List<Node> chicken = new ArrayList<>();

        int input;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    house.add(new Node(i, j));
                } else if (input == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

//        Node[] chicken_combi = new Node[M];

        boolean[] chicken_combi = new boolean[M];
        chicken_judge(house, chicken, chicken_combi, 0, 0);

        System.out.println(answer);
    }

    public static void chicken_judge(List<Node> house, List<Node> chicken, boolean[] chicken_combi, int start, int depth) {
        if (M == depth) {
            int min = 0;

            for (Node h : house) {
                int temp = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (chicken_combi[i]) {
                        temp = Math.min(temp, Math.abs(h.x - chicken.get(i).x) + Math.abs(h.y - chicken.get(i).y));
                    }
                }
                min += temp;
            }
            answer = Math.min(answer, min);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            chicken_combi[i] = true;
            chicken_judge(house, chicken, chicken_combi, start + 1, depth + 1);
            chicken_combi[i] = false;
        }

    }


    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
