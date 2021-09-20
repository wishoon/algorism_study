package Inflearn.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 씨름_선수_정답 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Human> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Human(height, weight));
        }
        solution(list, n);
    }

    public static void solution(List<Human> list, int n) {
        int cnt = 0;
        // 내림차순
        Collections.sort(list);

        int max = Integer.MIN_VALUE;

        for (Human human : list) {
            if(human.weight > max) {
                max = human.weight;
                cnt++;
            }
        }

        System.out.println(cnt);
    }


    static class Human implements Comparable<Human>{
        int height;
        int weight;

        public Human(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Human h) {
            return h.height - this.height;
        }
    }
}
