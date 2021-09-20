package Inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 피자_배달_거리 {
    static List<Node> home = new ArrayList<>();
    static List<Node> pizza = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0, m = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(n, m, arr);
    }

    public static void solution(int n, int m, int[][] arr) {
        int[] combi = new int[m];
        // 리스트에 저장
        saveList(home, pizza, arr);

        // pizza 조합 (list, 조합 수, 층)
        pizzaDFS(pizza, combi, m, 0, 0);

        System.out.println(min);
    }

    public static void pizzaDFS(List<Node> pizza, int[] combi, int m, int depth, int start) {
        if (depth == m) {
            min = Math.min(min, deliveryScore(combi));
        } else {
            for (int i = start; i < pizza.size(); i++) {
                combi[depth] = i;
                pizzaDFS(pizza, combi, m, depth + 1, i + 1);
            }
        }
    }

    public static int deliveryScore(int[] combi) {
        int sum = 0;
        for (Node h : home) {
            int dis = Integer.MAX_VALUE;
            for (int c : combi) {
                dis = Math.min(dis, Math.abs(h.x - pizza.get(c).x) + Math.abs(h.y - pizza.get(c).y));
            }
            sum += dis;
        }
        return sum;
    }

    public static void saveList(List<Node> home, List<Node> pizza, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    home.add(new Node(i, j));
                } else if(arr[i][j] == 2) {
                    pizza.add(new Node(i, j));
                }
            }
        }
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(Node node) {
            this.y = node.y;
            this.x = node.x;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
